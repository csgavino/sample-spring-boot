package com.example.demo

import com.example.demo.messages.MessageReceiverRepository
import com.example.demo.messages.MessageReceiverService
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.PatternTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.stereotype.Component

@Component
class RedisConfiguration {

    @Bean
    fun container(redisConnectionFactory: RedisConnectionFactory,
                  messageListenerAdapter: MessageListenerAdapter): RedisMessageListenerContainer {

        val redisMessageListenerContainer = RedisMessageListenerContainer()
        redisMessageListenerContainer.connectionFactory = redisConnectionFactory
        redisMessageListenerContainer.addMessageListener(
                messageListenerAdapter,
                PatternTopic("my-custom-channel"))

        return redisMessageListenerContainer
    }

    @Bean
    fun customerMessageReceiver(messageReceiverRepository: MessageReceiverRepository): MessageReceiverService {
        return MessageReceiverService(messageReceiverRepository);
    }

    @Bean
    fun customerMessageListenerAdapter(
            messageReceiverService: MessageReceiverService): MessageListenerAdapter {
        return MessageListenerAdapter(
                messageReceiverService,
                "messageReceived")
    }

//    @Bean
//    fun stringRedisTemplate(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
//        return StringRedisTemplate(connectionFactory)
//    }

}