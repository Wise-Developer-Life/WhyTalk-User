package com.wisedevlife.whytalkuser.common.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageQueueUtils {
    private final RabbitTemplate rabbitTemplate;

    public void publishMessageToQueue(String queueName, Object messagePayload) {
        rabbitTemplate.convertAndSend(queueName, messagePayload);
    }

    public void publishMessageToExchange(
            String exchangeName, String routingKey, Object messagePayload) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, messagePayload);
    }
}
