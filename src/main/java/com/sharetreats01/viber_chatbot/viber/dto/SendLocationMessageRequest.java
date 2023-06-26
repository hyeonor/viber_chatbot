package com.sharetreats01.viber_chatbot.viber.dto;

import com.sharetreats01.viber_chatbot.interaction.dto.callback.parameter.Location;

import lombok.Getter;

@Getter
public class SendLocationMessageRequest extends SendMessageRequest{
    private final String type = "location";
    private final Location location;

    public SendLocationMessageRequest(String receiver, String senderName, String senderAvatar, String trackingData, Integer minApiVersion, Location location) {
        super(receiver, senderName, senderAvatar, trackingData, minApiVersion);
        this.location = location;
    }
}
