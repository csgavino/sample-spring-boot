package com.example.demo.customers

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import java.util.*

fun buildDataSource(): MysqlDataSource {
    val dataSource = MysqlDataSource()
    dataSource.setUrl(System.getenv("TEST_DATABASE_URL"))
    dataSource.setUser(System.getenv("TEST_DATABASE_USER"))
    dataSource.setPassword(System.getenv("TEST_DATABASE_PASSWORD"))

    return dataSource
}

fun createCustomer(
        jdbcTemplate: JdbcTemplate,
        firstName: String,
        lastName: String) {

    val insert = SimpleJdbcInsert(jdbcTemplate)
            .withTableName("customers")
            .usingColumns(
                    "firstname",
                    "lastname")

    val params = HashMap<String, Any>()
    params["firstname"] = firstName
    params["lastname"] = lastName

    insert.execute(params)
}

fun truncateAllTables(jdbcTemplate: JdbcTemplate) {
    jdbcTemplate.update("TRUNCATE TABLE customers")
}

class JdbcCustomerDataMapperTest {

    private lateinit var jdbcTemplate: JdbcTemplate
    private lateinit var subject: JdbcCustomerDataMapper

    @Before
    fun setUp() {
        jdbcTemplate = JdbcTemplate(buildDataSource())
        subject = JdbcCustomerDataMapper(jdbcTemplate)
    }

    @After
    fun tearDown() {
        truncateAllTables(jdbcTemplate)
    }

    @Test
    fun test_findAll_returnsAllCustomers() {
        createCustomer(
                jdbcTemplate,
                "John",
                "Smith")

        val customers = subject.findAll()


        assertThat(customers[0].firstName).isEqualTo("John")
        assertThat(customers[0].lastName).isEqualTo("Smith")
    }

    @Test
    fun test_create_createsCustomers() {
        val customer = Customer(
                "Harry",
                "Potter")
        subject.create(customer)


        val customers = subject.findAll()


        assertThat(customers[0].firstName).isEqualTo("Harry")
        assertThat(customers[0].lastName).isEqualTo("Potter")
    }
}
