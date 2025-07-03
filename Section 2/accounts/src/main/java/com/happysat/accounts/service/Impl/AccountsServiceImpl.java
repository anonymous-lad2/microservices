package com.happysat.accounts.service.Impl;

import com.happysat.accounts.dto.CustomerDto;
import com.happysat.accounts.repository.AccountRepository;
import com.happysat.accounts.repository.CustomerRepository;
import com.happysat.accounts.service.AccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
