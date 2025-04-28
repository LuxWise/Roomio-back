package com.NotificationService.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue notificationsQueue() {
        return new Queue("notifications.queue", true); // Cola durable
    }
}
