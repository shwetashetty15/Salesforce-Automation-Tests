package com.commonutilities.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommomUtilities {

	public String getProperty(String name) throws IOException {
		String path = "/Users/srikanth/eclipse/trainingworkspace/SaleforceAccountFrameWork/data.properties";
		FileInputStream fileInput = new FileInputStream(path);
		Properties property = new Properties();
		property.load(fileInput);
		String value = property.getProperty(name);
		return value;
	}

}
