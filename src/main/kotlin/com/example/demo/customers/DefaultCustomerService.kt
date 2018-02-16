package com.example.demo.customers

import org.springframework.stereotype.Service

@Service
class DefaultCustomerService(val repository: CustomerRepository) : CustomerService {

    override fun getCustomers(): List<Customer> {
        return repository.findAll()
    }
}
