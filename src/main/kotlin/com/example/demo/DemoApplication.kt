package com.example.demo

import com.example.demo.customers.Customer
import com.example.demo.customers.CustomerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {
//    @Bean
//    fun init(repository: CustomerRepository) = CommandLineRunner {
//        repository.create(Customer("foo"))
//        repository.create(Customer("bar"))
//    }
}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
