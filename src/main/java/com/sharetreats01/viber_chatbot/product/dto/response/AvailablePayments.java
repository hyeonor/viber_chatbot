package com.sharetreats01.viber_chatbot.product.dto.response;

import com.sharetreats01.viber_chatbot.product.dto.response.parameter.Payment;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AvailablePayments {
    private List<Payment> payments;
}
