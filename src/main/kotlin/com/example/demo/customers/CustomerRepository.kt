package com.example.demo.customers

interface CustomerRepository {

    fun findAll(): List<Customer>

    fun create(customer: Customer)
}
