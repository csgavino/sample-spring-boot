package com.example.demo.messages

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class DefaultMessageReceiverRepository : MessageReceiverRepository {

    private val LOGGER = LoggerFactory.getLogger(MessageReceiverService::class.java)

    override fun messageReceived(message: String) {
        LOGGER.info(message)
    }
}
