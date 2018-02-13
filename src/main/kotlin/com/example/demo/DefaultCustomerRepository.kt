package com.example.demo

import org.springframework.stereotype.Repository

@Repository
class DefaultCustomerRepository : CustomerRepository {
    override fun getAll(): List<Customer> {
        return listOf(
                Customer("Larry"),
                Customer("Curly"),
                Customer("Moe"))
    }
}
