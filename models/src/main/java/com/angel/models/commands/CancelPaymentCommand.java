package com.angel.models.commands;

import com.angel.models.states.PaymentState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CancelPaymentCommand extends Command{

    private String paymentId;
    private PaymentState paymentState;

    public CancelPaymentCommand(String a){}


    @Builder
    public CancelPaymentCommand(String paymentId, PaymentState paymentState,
                                String orderId, String userId,
                                String productId, int quantity){
        super(userId, orderId, productId, quantity);
        this.paymentState = paymentState;
        this.paymentId = paymentId;

    }

}
