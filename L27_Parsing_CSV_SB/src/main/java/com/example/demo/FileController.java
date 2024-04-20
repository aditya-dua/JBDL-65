package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileController {

	@Autowired
	CSVService fileService;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		
		
		// Check for file format
		System.out.println(CSVHelper.hasCSVFormat(file));
		
		if(CSVHelper.hasCSVFormat(file)) {
			try {
				byte[] fileBytes = file.getBytes();
				Path path = Paths.get("/Users/adityadua/Documents/JBDL-65/"+file.getOriginalFilename());
				
				Files.write(path, fileBytes);
				
				fileService.save(file);
				
				
				return "File uploaded Successfully :: "+file.getOriginalFilename()+" "+path;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return "File uploaded Error!";
			}
		}else {
			return "Upload a CSV file";
		}
		
		
		
		
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile( ) {
	    InputStreamResource file = new InputStreamResource(fileService.download());

	    Date d = new Date();
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=tuts"+d+".csv" )
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	
	
}
