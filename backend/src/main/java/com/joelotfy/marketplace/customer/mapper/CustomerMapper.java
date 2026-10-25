package com.joelotfy.marketplace.customer.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.joelotfy.marketplace.customer.dto.CreateCustomerRequest;
import com.joelotfy.marketplace.customer.dto.CustomerResponse;
import com.joelotfy.marketplace.customer.dto.PatchCustomerRequest;
import com.joelotfy.marketplace.customer.entity.Customer;


@Mapper(componentModel = "spring") //tells mapstruct to make this a spring Bean
public interface CustomerMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Customer toCustomer(CreateCustomerRequest dto);

    //entity-> dto
    CustomerResponse toCustomerResponse(Customer customer);

    //so the mapper updates the existing object instead of creating a new one
    //will use IF i make a put endpoint
    // void updateEntityFromDto(CreateCustomerRequest dto, @MappingTarget Customer entity);

    //to ignore unspecified field on patch requests
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchCustomerFromDto(PatchCustomerRequest dto, @MappingTarget Customer entity);
}
