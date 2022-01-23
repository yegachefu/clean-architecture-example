package order.application.port.in.model;

import lombok.Getter;
import order.domain.Order;
import order.domain.OrderLineItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderRequest {
    //TODO 내부에서 사용하는 각 객체들도 Request로 만들 것..?

    private Long userId;

    private Long shopId;

    private List<OrderLineItem> orderLineItems = new ArrayList<>();

    private LocalDateTime orderedTime;

    private Order.OrderStatus orderStatus;

    public OrderRequest(Long userId, Long shopId, List<OrderLineItem> items, LocalDateTime orderedTime, Order.OrderStatus status) {
        this.userId = userId;
        this.shopId = shopId;
        this.orderedTime = orderedTime;
        this.orderStatus = status;
        this.orderLineItems.addAll(items);
    }

}
