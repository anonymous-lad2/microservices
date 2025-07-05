package com.happysat.accounts.service.Impl;

import com.happysat.accounts.constants.AccountsConstants;
import com.happysat.accounts.dto.CustomerDto;
import com.happysat.accounts.entity.Accounts;
import com.happysat.accounts.entity.Customer;
import com.happysat.accounts.exception.CustomerAlreadyExistsException;
import com.happysat.accounts.mapper.CustomerMapper;
import com.happysat.accounts.repository.AccountRepository;
import com.happysat.accounts.repository.CustomerRepository;
import com.happysat.accounts.service.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> opt = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if(opt.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given number " +customerDto.getMobileNumber());
        }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);

        accountRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer){

        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
