package com.example.demo.customers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun customers(): SerializedCustomer {
        return SerializedCustomer(customerService.getCustomers())
    }
}
