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
import com.se.spring.entity.Country;
import com.se.spring.entity.Customer;

@Service
public class CountryServiceImpl implements CountryService {
	private RestTemplate restTemplate;
	private String countryURl;
	private String custURl;
	@Autowired
	public CountryServiceImpl(RestTemplate restTemplate,@Value("${crm.rest.url.country}") String countryURl,@Value("${crm.rest.url.cust}") String custURl) {
		this.restTemplate = restTemplate;
		this.countryURl = countryURl;
		this.custURl=custURl;
	}
	public List<Customer> getCustomers(int idCountry) {
		// TODO Auto-generated method stub
		ResponseEntity<List<Customer>> responseEntity=
				restTemplate.exchange(custURl+"/"+idCountry, HttpMethod.GET,null,
						new ParameterizedTypeReference<List<Customer>>() {});
		List<Customer> customers=responseEntity.getBody();
		return customers;
	}
	public Country getCountry(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Country>> responseEntity=
				restTemplate.exchange(countryURl, HttpMethod.GET,null,
						new ParameterizedTypeReference<List<Country>>() {});
		List<Country> countries=responseEntity.getBody();
		return countries;
	}

}
