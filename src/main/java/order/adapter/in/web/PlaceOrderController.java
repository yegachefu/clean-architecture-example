package order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import order.application.port.in.OrderPort;
import order.domain.Cart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class PlaceOrderController {

    private final OrderPort orderPort;
    //주문
    @PostMapping("place")
    public void placeOrder(
            @RequestBody Cart cart
    ) { //request용 도메인?
        //validate
        orderPort.placeOrder(cart);
        //orderPayedPort 로 command 유효성 검증한 후 호출
    }
}
