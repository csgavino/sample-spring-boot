package com.example.demo

import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DefaultCustomerServiceTest {

    @Test
    fun test_getCustomers_returnsCustomers() {
        val customerRepo = mock(CustomerRepository::class.java)

        val service = DefaultCustomerService(customerRepo)
        service.getCustomers()

        verify(customerRepo).getAll()
    }
}
