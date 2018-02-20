package com.example.demo.customers

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import java.util.*

val customerRowMapper = RowMapper<Customer> { rs, rowNum ->
    Customer(
            rs.getString("firstName"),
            rs.getString("lastName")
    )
}

@Repository
class JdbcCustomerDataMapper(val jdbcTemplate: JdbcTemplate) {

    fun findAll(): List<Customer> {
        return jdbcTemplate
                .query("SELECT * FROM customers ORDER BY id DESC",
                        customerRowMapper)
    }

    fun create(customer: Customer) {
        val insert = SimpleJdbcInsert(jdbcTemplate)
                .withTableName("customers")
                .usingColumns(
                        "firstname",
                        "lastname")

        val params = HashMap<String, Any>()
        params["firstname"] = customer.firstName
        params["lastname"] = customer.lastName

        insert.execute(params)
    }
}
