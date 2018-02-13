package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DefaultCustomerRepositoryTest {

    @Test
    fun test_getAll_returnsCustomers() {
        val customerRepository = DefaultCustomerRepository()

        val customers = customerRepository.getAll()

        assertThat(customers).extracting("name")
                .contains("Larry", "Curly", "Moe")
    }
}
