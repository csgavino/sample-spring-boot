package com.example.demo.customers

import org.springframework.stereotype.Repository

@Repository
class JdbcCustomerRepository(val customerDataMapper: JdbcCustomerDataMapper) : CustomerRepository {

    override fun findAll(): List<Customer> {
        return customerDataMapper.findAll()
    }

    override fun create(customer: Customer) {
        customerDataMapper.create(customer)
    }
}
