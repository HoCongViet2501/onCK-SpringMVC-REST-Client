package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.se.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private RestTemplate restTemplate;
	private String custURl;
	
	@Autowired
	public CustomerServiceImpl(RestTemplate restTemplate,@Value("${crm.rest.url.cust}") String custURl) {
		this.restTemplate = restTemplate;
		this.custURl = custURl;
	}
	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int id=customer.getId();
		if(id==0) {
			restTemplate.postForEntity(custURl+"/add", customer, String.class);
		}else {
			restTemplate.put(custURl+"/update", customer);
		}
	}
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(custURl+"/delete/"+id);
		
	}
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer customer=restTemplate.getForObject(custURl+"/"+id, Customer.class);
		return customer;
	}
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Customer>> responseEntity=
				restTemplate.exchange(custURl, HttpMethod.GET,null,
						new ParameterizedTypeReference<List<Customer>>() {});
		List<Customer> customers=responseEntity.getBody();
		return customers;
	}

}
