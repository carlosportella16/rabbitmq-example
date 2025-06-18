package com.tech.pixms.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static String PIX_DONE_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public TopicExchange pixDoneExchange() {
        return new TopicExchange(PIX_DONE_EXCHANGE);
    }
}
