package com.fms;
import java.io.File;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fms.model.ExcelFileList;


public class Reader implements ItemReader<ExcelFileList> {

	@Override
	public ExcelFileList read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		ExcelFileList fileList = new ExcelFileList();
		return fileList;
	}
}
