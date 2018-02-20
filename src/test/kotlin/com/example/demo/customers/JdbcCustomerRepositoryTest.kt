package com.example.demo.customers

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class JdbcCustomerRepositoryTest {

    @Mock
    private lateinit var dataMapper: JdbcCustomerDataMapper

    private lateinit var subject: JdbcCustomerRepository

    @Before
    fun setUp() {
        subject = JdbcCustomerRepository(dataMapper)
    }

    @Test
    fun test_findAll_returnsAllCustomers() {
        val customers = listOf(
                Customer(firstName = "John", lastName = "Smith"))
        Mockito.`when`(dataMapper.findAll())
                .thenReturn(customers)


        val allCustomers = subject.findAll()


        assertThat(allCustomers[0].firstName).isEqualTo("John")
        assertThat(allCustomers[0].lastName).isEqualTo("Smith")
    }

    @Test
    fun test_create_createsCustomers() {
        val customer = Customer(firstName = "John", lastName = "Smith")


        subject.create(customer)


        val captor = argumentCaptor<Customer>()

        Mockito.verify(dataMapper).create(capture(captor))

        assertThat(captor.value.firstName).isEqualTo("John")
        assertThat(captor.value.lastName).isEqualTo("Smith")
    }
}
