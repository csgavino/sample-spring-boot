package com.example.demo.customers.persistence

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
interface JPACustomerAdapter : CrudRepository<JPACustomer, Long>
