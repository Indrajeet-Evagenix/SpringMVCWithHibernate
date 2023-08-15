package com.springhibernate.dao;

import java.util.List;

import com.springhibernate.model.Customer;

public interface CustomerDao {

	public List<Customer> listAllCustomers();

	public void saveOrUpdate(Customer customer);

	public Customer findCustomerById(int id);

	public void deleteCustomer(int id);

}
