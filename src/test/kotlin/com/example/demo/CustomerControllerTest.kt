package com.example.demo

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
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
                Customer("Larry"),
                Customer("Curly"),
                Customer("Moe")
        )
        Mockito.`when`(customerService.getCustomers())
                .thenReturn(customers)

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.customers[0].name").value("Larry"))
                .andExpect(jsonPath("$.customers[1].name").value("Curly"))
                .andExpect(jsonPath("$.customers[2].name").value("Moe"))
    }

}
