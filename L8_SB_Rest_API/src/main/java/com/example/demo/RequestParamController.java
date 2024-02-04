package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

	@RequestMapping("/test")
	public String test() {
		return "Test API works!";
	}
	
	@GetMapping(produces = "application/json")
	public Message getData() {
		Message msg = new Message();
		msg.setMsg("Test API works");
		return msg;
	}
	
	@GetMapping("/student")
	public Student getStudent() {
		Student s = new Student(1, "ADITYA", 100);
		s.setAdd(new Address());
		return s;
	}
	
	// 3 ways :
	// 1. Request Body
	// 2. Path Variable
	// 3. Request Param
	
	@RequestMapping("/profile/{name}")
	public String pathExample(@PathVariable String name) {
		return "Hello "+name;
	}
	
	@RequestMapping("/profile/{id}/{name}")
	public String pathExample1(@PathVariable("name") String name1,@PathVariable int id) {
		return "User "+name1+ "created with id:"+id;
	}
	//https://www.amazon.in/Nokia-8210-4G-Display-Wireless/dp/B0B7DHSSTM/?_encoding=UTF8&pd_rd_w=KecJL&content-id=amzn1.sym.44901b9b-bd56-4240-8b6b-3ad72079fb43%3Aamzn1.symc.adba8a53-36db-43df-a081-77d28e1b71e6&pf_rd_p=44901b9b-bd56-4240-8b6b-3ad72079fb43&pf_rd_r=WX7Y8WF1SYCYMXSMXTT2&pd_rd_wg=zjOmJ&pd_rd_r=59c7ae34-5d8f-4ec8-a7b1-de525d906e25&ref_=pd_gw_ci_mcx_mr_hp_atf_m&th=1
	// localhost:8080/profile/1?name=aditya
	// localhost:8080/<PathVariable>?<RequestParam>&<RequestParam>
	@RequestMapping("/")
	public String queryParamExample(@RequestParam(required=false) String name) {
		return "Hello "+name;
	}
	
	
	@RequestMapping ("/{name}")
	 public String helloUserAndShowDetails(@PathVariable("name") String name,@RequestParam String age, @RequestParam(required = false) String height) {
	  String str= "Hello ";
	  str+= age +" ";
	  str+=height +" ";
	  return str;
	 }
	
}
