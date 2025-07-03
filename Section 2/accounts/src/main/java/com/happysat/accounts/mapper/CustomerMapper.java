package com.happysat.accounts.mapper;

import com.happysat.accounts.dto.CustomerDto;
import com.happysat.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(CustomerDto customerDto, Customer customer){
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    public static Customer mapToCustomer(Customer customer, CustomerDto customerDto){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }
}
