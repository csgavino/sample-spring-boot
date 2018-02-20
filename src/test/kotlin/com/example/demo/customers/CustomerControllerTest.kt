package com.example.demo.customers

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class CustomerControllerTest {

    @InjectMocks
    private lateinit var customerController: CustomerController

    @Mock
    private lateinit var customerService: CustomerService

    private lateinit var mockMvc: MockMvc

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build()
    }

    @Test
    fun test_get_returnsCustomers() {
        val customers = listOf(
                Customer(firstName = "John", lastName = "Smith")
        )
        Mockito.`when`(customerService.getCustomers())
                .thenReturn(customers)

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.customers[0].firstName").value("John"))
                .andExpect(jsonPath("$.customers[0].lastName").value("Smith"))
    }

}
