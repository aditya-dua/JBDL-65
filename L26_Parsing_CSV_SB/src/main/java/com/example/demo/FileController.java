package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileController {

	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		
		
		
		try {
			byte[] fileBytes = file.getBytes();
			Path path = Paths.get("/Users/adityadua/Documents/JBDL-65/"+file.getOriginalFilename());
			
			Files.write(path, fileBytes);
			
			return "File uploaded Successfully :: "+file.getOriginalFilename()+" "+path;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return "File uploaded Error!";
		}
		
		
		
	}
}
