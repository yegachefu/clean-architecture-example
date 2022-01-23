package order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import order.adapter.in.web.model.CartRequest;
import order.adapter.in.web.model.OrderResponse;
import order.application.port.in.OrderUsecase;
import order.application.port.in.model.OrderRequest;
import order.domain.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class PlaceOrderController {

    private final OrderUsecase orderUsecase;
    private final OrderWebMapper orderRequestMapper;

    @PostMapping("place")
    public OrderResponse placeOrder(
            @RequestBody CartRequest cart
    ) {
        //validate
        //양방향 매핑
        OrderRequest orderRequest = orderRequestMapper.mapOrderRequestFrom(cart);
        Order createdOrder = orderUsecase.placeOrder(orderRequest);
        return orderRequestMapper.mapOrderResponseFrom(createdOrder);
    }
}
