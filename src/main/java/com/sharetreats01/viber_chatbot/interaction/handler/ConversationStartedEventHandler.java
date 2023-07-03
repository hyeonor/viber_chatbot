package com.sharetreats01.viber_chatbot.interaction.handler;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.ConversationStartedRequest;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.TrackingJSONData;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.request.property.User;
import com.sharetreats01.viber_chatbot.interaction.dto.callback.response.ConversationStartedResponse;
import com.sharetreats01.viber_chatbot.interaction.dto.message.template.WelcomeMessageTemplateValueDto;
import com.sharetreats01.viber_chatbot.viber.sender.MessageSenderBrands;
import com.sharetreats01.viber_chatbot.viber.enums.MessageType;
import com.sharetreats01.viber_chatbot.interaction.properties.ChatbotProperties;
import com.sharetreats01.viber_chatbot.interaction.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ConversationStartedEventHandler implements CallbackEventHandler<ConversationStartedRequest, ConversationStartedResponse> {
    private final ChatbotProperties properties;
    private final MessageService messageService;
    private final MessageSenderBrands brandProcessor;

    @Override
    public Class<ConversationStartedRequest> getCallbackType() {
        return ConversationStartedRequest.class;
    }

    @Override
    public ConversationStartedResponse handleEvent(ConversationStartedRequest request) {
        User user = request.getUser();
        String message = messageService.createMessage(
                new WelcomeMessageTemplateValueDto(MessageType.WELCOME, user.getLanguage(), user.getName(), properties.getBotName()));
        return ConversationStartedResponse.builder()
                .senderName(properties.getBotName())
                .senderAvatar(properties.getBotAvatar())
                .trackingJSONData(new TrackingJSONData())
                .type("text")
                .text(message)
                .build();
    }
}
