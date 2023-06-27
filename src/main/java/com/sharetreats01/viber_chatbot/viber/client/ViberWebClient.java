package com.sharetreats01.viber_chatbot.viber.client;

import com.sharetreats01.viber_chatbot.viber.dto.request.GetUserDetailsRequest;
import com.sharetreats01.viber_chatbot.viber.dto.request.SendMessageRequest;
import com.sharetreats01.viber_chatbot.viber.dto.response.SendMessageResponse;
import com.sharetreats01.viber_chatbot.viber.dto.request.SetWebhookRequest;
import com.sharetreats01.viber_chatbot.viber.dto.response.SetWebhookResponse;

public interface ViberWebClient {
    SetWebhookResponse sendWebhookSetting(SetWebhookRequest request);
    SendMessageResponse sendMessage(SendMessageRequest request);

    com.sharetreats01.viber_chatbot.viber.dto.response.GetUserDetailsResponse getUserDetails(GetUserDetailsRequest request);
}
