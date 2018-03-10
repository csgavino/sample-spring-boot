package com.example.demo

import com.example.demo.messages.CustomerMessageReceiver
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
    fun customerMessageReceiver(): CustomerMessageReceiver {
        return CustomerMessageReceiver();
    }

    @Bean
    fun customerMessageListenerAdapter(
            customerMessageReceiver: CustomerMessageReceiver): MessageListenerAdapter {
        return MessageListenerAdapter(
                customerMessageReceiver,
                "receiveMessage")
    }

//    @Bean
//    fun stringRedisTemplate(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
//        return StringRedisTemplate(connectionFactory)
//    }

}