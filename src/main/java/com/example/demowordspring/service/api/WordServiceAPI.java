package com.example.demowordspring.service.api;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public interface WordServiceAPI {
	
	/**
	 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a> 
	 * @date 8 feb. 2022
	 * @description 
	 * @HU_CU_REQ 
	 * @param title
	 * @param imagePath
	 * @param fileName
	 */
	void createWord(String title, String imagePath, String fileName) throws InvalidFormatException, IOException;

}
