package com.example.demo.customers.persistence

import com.example.demo.customers.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class JPACustomerRepositoryTest {

    @Mock
    private lateinit var adapter: JPACustomerAdapter

    private lateinit var repository: JPACustomerRepository

    @Before
    fun setUp() {
        repository = JPACustomerRepository(adapter)

        val customers = mutableListOf(
                JPACustomer(1, "John"),
                JPACustomer(2, "Sally"))

        Mockito.`when`(adapter.findAll()).thenReturn(customers)
    }

    @Test
    fun test_getAll_returnsCustomers() {
        val customers = repository.findAll()


        assertThat(customers).extracting("name")
                .contains("John", "Sally")
    }

    @Test
    fun test_save_savesCustomers() {
        val customer = Customer("John")


        repository.save(customer)


        val argument = ArgumentCaptor.forClass(JPACustomer::class.java)

        Mockito.verify(adapter).save(argument.capture())

        assertThat(argument.value.id).isEqualTo(null)
        assertThat(argument.value.name).isEqualTo("John")
    }
}
