package com.tech.pjms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String PJ_QUEUE = "pj-queue";
    public static final String PIX_DONE_EXCHANGE = "pix-efetuado";
    private static final String PJ_ROUTING_KEY = "pj";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue pjQueue() {
        return new Queue(PJ_QUEUE);
    }

    @Bean
    public TopicExchange pixDoneExchange() {
        return new TopicExchange(PIX_DONE_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue pjQueue, TopicExchange pixDoneExchange) {
        return BindingBuilder.bind(pjQueue).to(pixDoneExchange).with(PJ_ROUTING_KEY);
    }
}
