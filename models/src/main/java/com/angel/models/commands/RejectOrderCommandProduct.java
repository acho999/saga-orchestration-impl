package com.angel.models.commands;

import com.angel.models.states.OrderState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RejectOrderCommandProduct extends Command{

    private String reason;
    private OrderState state = OrderState.CANCELLED;
    private String paymentId;

    public RejectOrderCommandProduct(String a){}


    @Builder
    public RejectOrderCommandProduct(String reason, String userId, String orderId, String productId, String paymentId){
        super(userId, orderId, 0.0d, productId, 0);
        this.reason = reason;
        this.paymentId = paymentId;
    }

}