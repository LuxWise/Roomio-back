package com.NotificationService.messaging;

import com.NotificationService.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final MailService mailService;

    @RabbitListener(queues = "notifications.queue")
    public void handleNotificationEvent(String message) {
        // NotificationRequest request = objectMapper.readValue(message, NotificationRequest.class);
        // mailService.sendHtmlEmail(request.getTo(), request.getSubject(), request.getContent());
        System.out.println("Mensaje recibido: " + message);
    }
}
