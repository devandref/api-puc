package io.github.devandref.pucminastrabalho.pucminastrabalho.controller;

import io.github.devandref.pucminastrabalho.pucminastrabalho.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StreamingController {

    @MessageMapping("/chat/sendMessage")
    @SendTo("/topic/public") // Envia a mensagem para todos os clientes inscritos no tópico "/topic/public"
    public Message sendMessage(Message message) {
        return message;
    }

    @MessageMapping("/chat/addUser")
    @SendTo("/topic/public") // Envia a mensagem para todos os clientes inscritos no tópico "/topic/public"
    public Message addUser(Message message) {
        return message;
    }


}

