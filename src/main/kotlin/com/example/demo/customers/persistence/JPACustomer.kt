package com.example.demo.customers.persistence

import javax.persistence.*

@Table(name = "customers")
@Entity
class JPACustomer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = -1,
        val name: String = "")
