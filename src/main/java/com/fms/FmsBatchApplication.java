package com.fms;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@ComponentScan("com.fms")
@EnableScheduling
public class FmsBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsBatchApplication.class, args);
		
	}
	
	@Autowired
    JobLauncher jobLauncher;
      
    @Autowired
    Job job;
    
   // @Scheduled(cron = "0 */1 * * * ?")
    //
    @Scheduled(cron = "0/30 * * * * ?")
    public void perform() throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }

}
