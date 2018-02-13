package com.example.demo

import org.springframework.stereotype.Service

@Service
class DefaultCustomerService(val customerRepository: CustomerRepository) : CustomerService {

    override fun getCustomers(): List<Customer> {
        return customerRepository.getAll()
    }

}
