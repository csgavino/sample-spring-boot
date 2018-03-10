package com.example.demo.messages

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CustomerMessageReceiver() {

    private val LOGGER = LoggerFactory.getLogger(CustomerMessageReceiver::class.java)

    fun receiveMessage(message: String) {
        LOGGER.info(message)
    }

}
