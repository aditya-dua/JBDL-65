package org.geeksforgeeks.jbdl65.L7_Introd_to_SB;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hw")
//@RestController = Controller + ResponseBody
public class HelloWorldController {

	@RequestMapping(value = "/test")
	public String test() {
		return "Test API works";
	}
	
	@RequestMapping(value = "/test")
	public String helloWorld() {
		return "Test API works";
	}
}
