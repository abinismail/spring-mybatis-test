/**
 * 
 */
package com.abin.test.framework;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abin.test.entity.PeopleEntity;
import com.abin.test.user.dao.UserMapper;

/**
 * @author abin
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("!!! JOB FINISHED! Time to verify the results");

			List<PeopleEntity> rs = userMapper.getAllUsers();

			rs.forEach(user -> System.out.println("----------------" + user.toString()));
		}
	}

}
