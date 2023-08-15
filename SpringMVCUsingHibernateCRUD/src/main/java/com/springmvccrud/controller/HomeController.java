package com.springmvccrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvccrud.entity.Customer;
import com.springmvccrud.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class HomeController {

//	@RequestMapping(value = "/")
//	public ModelAndView test(HttpServletResponse response) throws IOException {
//		return new ModelAndView("home");
//	}

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCustomer(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		theModel.addAttribute("customer", theCustomers);
		return "list-customers";

	}

	@RequestMapping(value = "/showForm", method = RequestMethod.GET)
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
