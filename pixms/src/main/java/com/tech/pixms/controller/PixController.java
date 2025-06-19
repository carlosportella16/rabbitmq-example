package com.tech.pixms.controller;

import com.tech.pixms.controller.dto.PixReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tech.pixms.config.RabbitMqConfig.PIX_DONE_EXCHANGE;

@RestController
@RequestMapping("/pix")
public class PixController {

    private final Logger logger = LoggerFactory.getLogger(PixController.class);

    private final RabbitTemplate rabbitTemplate;

    public PixController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> makePix(@RequestBody PixReq pixReq) {
        rabbitTemplate.convertAndSend(PIX_DONE_EXCHANGE, pixReq.channel(), pixReq);
        logger.info("PIX MS - PIX sent {}", pixReq);
        return ResponseEntity.accepted().build();
    }
}
