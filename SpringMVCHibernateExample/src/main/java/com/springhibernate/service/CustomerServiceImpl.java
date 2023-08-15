package com.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.dao.CustomerDao;
import com.springhibernate.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerDao customerDao;

//	public void setCustomerDao(CustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}

	public List<Customer> listAllCustomers() {
		return customerDao.listAllCustomers();
	}

	public void saveOrUpdate(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}

	public Customer findCustomerById(int id) {
		return customerDao.findCustomerById(id);
	}

	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
