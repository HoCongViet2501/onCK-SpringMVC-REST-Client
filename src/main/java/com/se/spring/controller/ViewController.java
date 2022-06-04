package com.se.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.Customer;
import com.se.spring.service.CountryService;
import com.se.spring.service.CustomerService;

@Controller
public class ViewController{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/")
	public String listCustomers(Model model) {
		List<Customer> customers=customerService.getCustomers();
		model.addAttribute("customers",customers);
		return "listCustomer";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customers",customer);
		return "customerForm";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCust(@RequestParam("id") int id){
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
	@GetMapping("/customerFormUpdate")
	public String showFormforUpdate(@RequestParam("id") int id,Model model) {
		Customer customer=customerService.getCustomerById(id);
		model.addAttribute("customers",customer);
		return "customerForm";
	}
	@GetMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customers") Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/";
		
	}
}