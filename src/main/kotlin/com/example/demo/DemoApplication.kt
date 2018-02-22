package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

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
