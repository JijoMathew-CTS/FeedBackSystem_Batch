package com.fms;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.fms.model.ExcelFileList;

public class Writer implements ItemWriter<ExcelFileList> {

	@Override
	public void write(List<? extends ExcelFileList> excelFileList) throws Exception {
		
	}

}