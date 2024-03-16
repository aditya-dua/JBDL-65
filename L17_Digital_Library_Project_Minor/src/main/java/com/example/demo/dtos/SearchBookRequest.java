package com.example.demo.dtos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchBookRequest {
	
	@NotBlank
	private String searchKey;
	@NotBlank
	private String searchValue;
	@NotBlank
	private String operator;
	
	private static Set<String> allowedKeys = new HashSet<>();
	private static HashMap<String, List<String>> allowedOperatorMap = new HashMap();
	SearchBookRequest(){
		allowedKeys.addAll(Arrays.asList("name","author_name","genre","pages","id"));
		allowedOperatorMap.put("name",Arrays.asList("=","like"));
		allowedOperatorMap.put("author_name",Arrays.asList("="));
		allowedOperatorMap.put("pages",Arrays.asList("=","<","<=",">=",">"));
		allowedOperatorMap.put("genre",Arrays.asList("="));
		allowedOperatorMap.put("id",Arrays.asList("="));	
	}
	
	public boolean validate() {
		if(!allowedKeys.contains(searchKey)) {
			return false;
		}
		List<String> validOperators =allowedOperatorMap.get(this.searchKey);
		if(!validOperators.contains(this.operator)) {
			return false;
		}
		return true;
	}

}
