package com.tech.pfms.listener;

import com.tech.pfms.listener.dto.PixReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.tech.pfms.config.RabbitMqConfig.PF_QUEUE;

@Component
public class PfListener {

    private final Logger logger = LoggerFactory.getLogger(PfListener.class);

    @RabbitListener(queues = PF_QUEUE)
    public void listen(Message<PixReq> message){
        logger.info("PF MS - Message consumed: {}", message);
    }
}
