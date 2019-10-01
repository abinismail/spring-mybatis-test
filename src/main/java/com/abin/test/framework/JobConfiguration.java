package com.abin.test.framework;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.abin.test.entity.PeopleEntity;
import com.abin.test.user.service.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public SqlSessionFactoryBean sqlSessionFactoryBean;

	@Bean
	public FlatFileItemReader<PeopleEntity> reader() {
		return new FlatFileItemReaderBuilder<PeopleEntity>().name("personItemReader")
				.resource(new ClassPathResource("sample-data.csv")).delimited()
				.names(new String[] { "firstName", "lastName", "age", "companyName" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<PeopleEntity>() {
					{
						setTargetType(PeopleEntity.class);
					}
				}).build();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public MyBatisBatchItemWriter<PeopleEntity> writer() throws Exception {
		return new MyBatisBatchItemWriterBuilder<PeopleEntity>()
				.sqlSessionFactory(sqlSessionFactoryBean.getObject())
				.statementId("com.abin.test.user.dao.UserMapper.addUser")
				.build();
	}
	
	@Bean
	public org.springframework.batch.core.Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	        .incrementer(new RunIdIncrementer())
	        .listener(listener)
	        .flow(step1)
	        .end()
	        .build();
	}

	@Bean
	public Step step1(MyBatisBatchItemWriter<PeopleEntity> writer) {
	    return stepBuilderFactory.get("step1")
	        .<PeopleEntity, PeopleEntity> chunk(10)
	        .reader(reader())
	        .processor(processor())
	        .writer(writer)
	        .build();
	}



}
