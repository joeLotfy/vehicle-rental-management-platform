package com.joelotfy.marketplace.customer.mapper;

import org.mapstruct.Mapper;

import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.dto.CustomerResponse;
import com.joelotfy.marketplace.customer.entity.Customer;


@Mapper (componentModel = "spring")
public interface CustomerMapper {
    //dto-> entity
    Customer toCustomer(CreateCustomerRequest dto);

    //entity-> dto
    CustomerResponse toCustomerResponse(Customer customer);
}
