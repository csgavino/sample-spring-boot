package com.example.demo.customers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DefaultCustomerServiceTest {

    @Mock
    private lateinit var repository: CustomerRepository

    private lateinit var subject: CustomerService

    @Before
    fun setUp() {
        subject = DefaultCustomerService(repository)
    }

    @Test
    fun test_getCustomers_returnsCustomers() {
        subject.getCustomers()

        verify(repository).findAll()
    }
}
