package com.example.demowordspring.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import com.example.demowordspring.service.api.WordServiceAPI;

/**
 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
 * @project demo-word-spring
 * @class WordServiceImpl
 * @description
 * @HU_CU_REQ
 * @date 8 feb. 2022
 */
@Service
public class WordServiceImpl implements WordServiceAPI {

	/**
	 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
	 * @date 8 feb. 2022
	 * @param title
	 * @param imagePath
	 * @param fileName
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @see com.example.demowordspring.service.api.WordServiceAPI#createWord(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void createWord(String title, String imagePath, String fileName) throws InvalidFormatException, IOException {
		var document = new XWPFDocument();

		var titleParagraph = document.createParagraph();
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);
		var titleRun = titleParagraph.createRun();
		titleRun.setText(title);
		titleRun.setColor("106BF3");
		titleRun.setBold(true);
		titleRun.setFontFamily("Courier");
		titleRun.setFontSize(30);

		var image = document.createParagraph();
		image.setAlignment(ParagraphAlignment.CENTER);

		var imageRun = image.createRun();
		imageRun.setTextPosition(20);
		Path path = Paths.get(imagePath);
		imageRun.addPicture(Files.newInputStream(path), XWPFDocument.PICTURE_TYPE_PNG, path.getFileName().toString(),
				Units.toEMU(200), Units.toEMU(50));
		
		
		FileOutputStream outputStream = new FileOutputStream(new File(System.getProperty("user.home") + File.separator + fileName));
		document.write(outputStream);
		outputStream.close();
		document.close();
		

	}

}
