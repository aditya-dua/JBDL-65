package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {

	@Autowired
	TutorialRepository repository;
	
	public void save(MultipartFile file) {
		try {
			List<Tutorial> tuts=CSVHelper.csvToTutorials(file.getInputStream());
		
			repository.saveAll(tuts);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public ByteArrayInputStream download() {
		List<Tutorial> tutorialList = repository.findAll();
		
		
		ByteArrayInputStream input = CSVHelper.tutorialToCSV(tutorialList);
		
		
		return input;
		
	}
}
