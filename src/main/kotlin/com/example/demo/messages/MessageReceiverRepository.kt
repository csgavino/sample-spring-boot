package com.example.demo.messages

interface MessageReceiverRepository {

    fun messageReceived(message: String)
}
