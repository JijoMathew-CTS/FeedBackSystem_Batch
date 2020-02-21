package com.fms.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class SaveItemWriter<T> implements ItemWriter<T> { 
    @Override
    public void write(List<? extends T> items) throws Exception { 
        for (T item : items) { 
            System.out.println(item); 
        } 
    } 
}