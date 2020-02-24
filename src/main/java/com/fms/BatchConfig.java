package com.fms;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.fms.model.ExcelFileList;
import com.fms.processor.DBLogProcessor;
import com.fms.writer.SaveItemWriter;
 
@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    private Environment env;
     
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private DBLogProcessor dBLogProcessor;
 
    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readExcelFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
    
    
 
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<ExcelFileList, ExcelFileList>chunk(5)
        		.reader(new Reader())
        		.processor(processor())               
                .writer(new Writer())
                .build();
    }
    
    public ItemProcessor<ExcelFileList, ExcelFileList> processor() {
        return dBLogProcessor;
    }
    
}