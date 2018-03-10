package com.example.demo.messages

import org.springframework.stereotype.Component

@Component
class MessageReceiverService(val messageReceiverRepository: MessageReceiverRepository) {

    fun messageReceived(message: String) {
        messageReceiverRepository.messageReceived(message)
    }

}
