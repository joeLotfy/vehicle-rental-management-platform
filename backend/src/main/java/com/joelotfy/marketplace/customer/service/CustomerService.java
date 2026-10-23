package com.joelotfy.marketplace.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.dto.CustomerResponse;
import com.joelotfy.marketplace.customer.entity.Customer;
import com.joelotfy.marketplace.customer.mapper.CustomerMapper;
import com.joelotfy.marketplace.customer.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    
    @Autowired 
    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;        
    }

    @Transactional 
    public CustomerResponse createCustomer(CreateCustomerRequest request){
        //map the dto to JPA entity
        // Customer customerEntity = new Customer(); //will not try to map with a constructor cuz ion wanna inject all these fields in a constructor
        Customer customerEntity = customerMapper.toCustomer(request);

        //save
        Customer savedCustomer = customerRepository.save(customerEntity);

        //convert saved entity to as a safe resopnse DTO
        return customerMapper.toCustomerResponse(savedCustomer);
    }
}
