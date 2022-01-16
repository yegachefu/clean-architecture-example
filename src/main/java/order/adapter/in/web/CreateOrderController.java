package order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import order.application.port.in.OrderPayedPort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class CreateOrderController {

    private final OrderPayedPort orderPayedPort;

    @PostMapping
    public void createOrder(
            @RequestBody CreateOrderCommand createOrderCommand
    ) { //request용 도메인?

        //orderPayedPort 로 command 유효성 검증한 후 호출
    }
}
