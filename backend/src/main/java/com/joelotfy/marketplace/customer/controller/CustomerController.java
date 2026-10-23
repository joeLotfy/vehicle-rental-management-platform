package com.joelotfy.marketplace.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.joelotfy.marketplace.customer.entity.Customer;
import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.dto.CustomerResponse;
import com.joelotfy.marketplace.customer.dto.PatchCustomerRequest;
import com.joelotfy.marketplace.customer.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor 
@RequestMapping ("/api/v1/customers")
public class CustomerController {

    @Autowired 
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping 
    public ResponseEntity<CustomerResponse> createCustomer (@Valid @RequestBody CreateCustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<CustomerResponse> patchCustomer (@PathVariable Long id ,@Valid @RequestBody PatchCustomerRequest request){
        return ResponseEntity.ok(customerService.patchCustomer(id, request));    
    }
}
