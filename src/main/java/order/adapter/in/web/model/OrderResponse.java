package order.adapter.in.web.model;

import lombok.Getter;
import order.domain.OrderLineItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponse {
    private Long shopId;
    private List<OrderLineItem> orderLineItems = new ArrayList<>();
    private LocalDateTime orderedTime;

    public OrderResponse(Long shopId, List<OrderLineItem> orderLineItems, LocalDateTime orderedTime) {
        this.shopId = shopId;
        this.orderLineItems = orderLineItems;
        this.orderedTime = orderedTime;
    }
}
