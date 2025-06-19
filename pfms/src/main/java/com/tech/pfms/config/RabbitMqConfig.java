package com.tech.pfms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String PF_QUEUE = "pf-queue";
    public static final String PIX_DONE_EXCHANGE = "pix-efetuado";
    private static final String PF_ROUTING_KEY = "pf";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue pfQueue() {
        return new Queue(PF_QUEUE);
    }

    @Bean
    public TopicExchange pixDoneExchange() {
        return new TopicExchange(PIX_DONE_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue pfQueue, TopicExchange pixDoneExchange) {
        return BindingBuilder.bind(pfQueue).to(pixDoneExchange).with(PF_ROUTING_KEY);
    }
}
