package com.example.demo.messages

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CustomerMessageReceiverTest {

    @Mock
    private lateinit var messageReceiverRepository: MessageReceiverRepository

    @Test
    fun test_receiveMessage_receivesMessages() {
        val subject = MessageReceiverService(messageReceiverRepository)

        subject.messageReceived("This is a message")

        verify(messageReceiverRepository).messageReceived("This is a message")
    }

}