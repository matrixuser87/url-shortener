/*
 * Developed by Bobi and Tzvetan <bzn@abv.bg>
 * Copyright (c) 2019.
 */

package com.project.shortener.services;

import com.project.shortener.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Message producer.
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageProducer {


    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    /**
     * Producet rabbitmq message.
     */
    public void produce() {

        Message message =
                Message.builder().id(UUID.randomUUID()).msg("Sample Message").date(LocalDateTime.now()).build();

        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        log.info("Message was sent {}.", message);
    }

}
