package com.tech.auditms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String AUDIT_QUEUE = "audit-queue";
    public static final String PIX_DONE_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(AUDIT_QUEUE);
    }

    @Bean
    public TopicExchange pixDoneExchange() {
        return new TopicExchange(PIX_DONE_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue auditQueue, TopicExchange pixDoneExchange) {
        return BindingBuilder.bind(auditQueue).to(pixDoneExchange).with("*");
    }
}
