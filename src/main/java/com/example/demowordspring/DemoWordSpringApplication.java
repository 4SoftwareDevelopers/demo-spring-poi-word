package com.example.demowordspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demowordspring.service.api.WordServiceAPI;

@SpringBootApplication
public class DemoWordSpringApplication implements CommandLineRunner{
	
	@Autowired
	private WordServiceAPI wordServiceAPI;

	public static void main(String[] args) {
		SpringApplication.run(DemoWordSpringApplication.class, args);
	}

	/**
	 * @author <a href="mailto:4softwaredevelopers@gmail.com">Jordy Rodríguezr</a>
	 * @date 8 feb. 2022 
	 * @param args
	 * @throws Exception 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		wordServiceAPI.createWord("Document tutorial 4SD", "src/main/resources/images/logo_4sd.png", "test_4sd.docx");
		
	}

}
