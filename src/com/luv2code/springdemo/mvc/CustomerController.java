package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Add an InitBinder to convert trim input strings
	// Remove leading and trailing white spaces
	// Resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class,ste);
		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("customer",new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("Last Name : |"+theCustomer.getLastName()+"|");
		
		System.out.println("Binding Result : "+theBindingResult);
		System.out.println("\n\n\n");
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
		
	}
}
