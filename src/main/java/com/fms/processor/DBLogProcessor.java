package com.fms.processor;

import java.io.File;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fms.model.ExcelFileList;
import com.fms.service.ExcelService;

@Component
public class DBLogProcessor implements ItemProcessor<ExcelFileList, ExcelFileList>
{
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExcelService excelService;
	
    public ExcelFileList process(ExcelFileList excelFile) throws Exception
    {
    	File file = new File(environment.getProperty("excel.file.path"));
    	ExcelFileList excelFileList = new ExcelFileList();
    	if(file.exists() && file.isDirectory())
    	{
    		excelFileList.setFileList(file.list());
    	}
    	if(excelFileList.getFileList() != null && excelFileList.getFileList().length>0) {
    		for(String fileName : excelFileList.getFileList()) {
    			excelService.saveExcel(fileName);
    		}
    	}
      
        return excelFileList;
    }
}