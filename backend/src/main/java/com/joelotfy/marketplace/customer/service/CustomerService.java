package com.joelotfy.marketplace.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.dto.CustomerResponse;
import com.joelotfy.marketplace.customer.dto.PatchCustomerRequest;
import com.joelotfy.marketplace.customer.entity.Customer;
import com.joelotfy.marketplace.customer.mapper.CustomerMapper;
import com.joelotfy.marketplace.customer.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final PasswordEncoder passwordEncoder;

    //create customer POST API
    @Transactional 
    public CustomerResponse createCustomer(CreateCustomerRequest request){
        //map the dto to JPA entity
        // Customer customerEntity = new Customer(); //will not try to map with a constructor cuz ion wanna inject all these fields in a constructor
        Customer customerEntity = customerMapper.toCustomer(request);

        //hash the password from the DTO and inject it
        String secureHash = passwordEncoder.encode(request.passwordHash());
        customerEntity.setPasswordHash(secureHash);

        //save
        Customer savedCustomer = customerRepository.save(customerEntity);

        //convert saved entity to as a safe resopnse DTO
        return customerMapper.toCustomerResponse(savedCustomer);
    }

    //get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //get by id
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    //patch
    @Transactional 
    public CustomerResponse patchCustomer(Long id, PatchCustomerRequest request){
        //fetch managed entity
        Customer customer = customerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Not Found"));
        
        //mapper patches the fields automatically to managed entity
        customerMapper.patchCustomerFromDto(request, customer);
        
        //Hibernate saves automatically

        //map to response dto and return it
        return customerMapper.toCustomerResponse(customer);
    }
}
