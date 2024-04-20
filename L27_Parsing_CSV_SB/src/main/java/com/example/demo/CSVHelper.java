package com.example.demo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
	
	public static boolean hasCSVFormat(MultipartFile file) {
		System.out.println(file.getContentType());
		
		if(file.getContentType().equals("application/vnd.ms-excel")||file.getContentType().equals("text/csv")) {
			return true;
		}
		
		return false;
		
	}
	
	public static List<Tutorial> csvToTutorials(InputStream is){
		List<Tutorial> tutorialList = new ArrayList<Tutorial>();
		
		BufferedReader fileReader;
		try {
			fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for (CSVRecord csvRecord : csvRecords) {
				
				Tutorial t = new Tutorial(Long.parseLong(csvRecord.get("Id")), 
						csvRecord.get("Title"), 
						csvRecord.get("Description"),
						Boolean.parseBoolean(csvRecord.get("Status")));
				
				tutorialList.add(t);
			}
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tutorialList;
	}

	
	public static ByteArrayInputStream tutorialToCSV(List<Tutorial> tutorialsList) {
		
		CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			
			CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);
			
			for (Tutorial tutorial : tutorialsList) {
				List<String> data = Arrays.asList(
						String.valueOf(tutorial.getId()),tutorial.getName(),tutorial.getDescription(),String.valueOf(tutorial.isStatus()));
				csvPrinter.printRecord(data);
			}
			
			csvPrinter.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
		
	
		
	}
}
