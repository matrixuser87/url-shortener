/*
 * Developed by Bobi and Tzvetan <bzn@abv.bg>
 * Copyright (c) 2019.
 */

package com.project.shortener.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Message domain object, used for rabbitmq messaging..
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private UUID id;
    private String msg;
    private LocalDateTime date;
    private int a;
}
