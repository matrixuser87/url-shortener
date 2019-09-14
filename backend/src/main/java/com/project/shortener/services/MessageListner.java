/*
 * Developed by Bobi and Tzvetan <bzn@abv.bg>
 * Copyright (c) 2019.
 */

package com.project.shortener.services;

import com.project.shortener.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Message listener.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class MessageListner {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(Message message) {
        log.info("Payload {} ", message);
    }
}
