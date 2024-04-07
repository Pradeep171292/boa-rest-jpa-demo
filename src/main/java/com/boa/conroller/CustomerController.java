package com.boa.conroller; 

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Customer;
import com.boa.service.CustomerService;

@RestController
public class CustomerController {
	//1)open source logger appache log4j 2) Spring logger  sl4j 
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Customer> getAllUsers(@PathVariable Long id) {
		logger.info("inside the customerById method");
		logger.debug("id is -- " + id);
		return customerService.getById(id);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer> getAll() {
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/customerByName/{name}", method = RequestMethod.GET)
	public List<Customer> getCustomerByName(@PathVariable String name) {
		return customerService.findByName(name);
	}
	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteCustomer(@PathVariable Long id) {
		customerService.deletecustomer(id);
		return HttpStatus.NO_CONTENT;
	}
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public HttpStatus insertCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public HttpStatus updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/customerbyage/{age}", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomerByAge(@PathVariable int age) {
		return customerService.getAllCustomersByAge(age);
	}
}
