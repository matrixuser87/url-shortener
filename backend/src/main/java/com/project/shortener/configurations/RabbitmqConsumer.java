/*
 * Developed by Bobi and Tzvetan <bzn@abv.bg>
 * Copyright (c) 2019.
 */

package com.project.shortener.configurations;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Consumer config.
 */
@Configuration
@EnableRabbit
public class RabbitmqConsumer implements RabbitListenerConfigurer {

    /**
     * Adding a RabbitMQ listener which will convert the Json Message Back to POJO.
     */
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(defaultMessageHandlerMethodFactory());
    }

    /**
     * Setting up a Message handler factory which set Json to Pojo Convert.
     */
    @Bean
    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory() {

        DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory =
                new DefaultMessageHandlerMethodFactory();

        defaultMessageHandlerMethodFactory.setMessageConverter(mappingJackson2MessageConverter());

        return defaultMessageHandlerMethodFactory;

    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }
}
