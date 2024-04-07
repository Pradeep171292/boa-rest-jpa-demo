package com.boa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.entity.Customer;
import com.boa.repo.CustomerReposetory;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	CustomerReposetory<Customer> customerRepository;

	@Transactional
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Transactional
	public List<Customer> findByName(String name) {
		return customerRepository.findByFirstName(name);
	}

	@Transactional
	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	}

	@Transactional
	public void deletecustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	@Transactional
	public boolean addCustomer(Customer customer) {
		return customerRepository.save(customer) != null;
	}

	@Transactional
	public boolean updateCustomer(Customer customer) {
		return customerRepository.save(customer) != null;
	}

	@Transactional
	public List<Customer> getAllCustomersByAge(int age) {
		return (List<Customer>) customerRepository.findByAge(age);
	}
}
