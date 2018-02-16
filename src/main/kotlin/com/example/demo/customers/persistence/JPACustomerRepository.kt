package com.example.demo.customers.persistence

import com.example.demo.customers.Customer
import com.example.demo.customers.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class JPACustomerRepository(val adapter: JPACustomerAdapter) : CustomerRepository {

    override fun findAll(): List<Customer> = adapter.findAll().map {
        Customer(it.name)
    }

    override fun save(customer: Customer) {
        val jpaCustomer = JPACustomer(null, customer.name)
        adapter.save(jpaCustomer)
    }
}
