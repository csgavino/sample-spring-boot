package com.example.demo.customers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

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
        val customers = listOf(
                Customer(firstName = "John", lastName = "Smith"))
        Mockito.`when`(repository.findAll())
                .thenReturn(customers)


        val actualCustomers = subject.getCustomers()


        assertThat(actualCustomers[0].firstName).isEqualTo("John")
        assertThat(actualCustomers[0].lastName).isEqualTo("Smith")
    }
}
