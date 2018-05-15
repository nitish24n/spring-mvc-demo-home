package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show initial html page/form
	@RequestMapping("/showForm")	//can be any name nonetheless
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//add a new controller method to read the form data 
	//and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//Read the request parameter from the html data
		String name = request.getParameter("studentName");
		
		//convert the data to uppercase
		name = name.toUpperCase();
		
		//create the message 
		String result = "Yo!-"+name;
		
		//add the message to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String name, 
			Model model) {
		
		//convert the data to uppercase
		name = name.toUpperCase();
		
		//create the message 
		String result = "Hey! "+name;
		
		//add the message to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}

}
