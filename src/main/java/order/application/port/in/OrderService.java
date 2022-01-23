package order.application.port.in;

import order.adapter.in.web.OrderMapper;
import order.adapter.out.persistence.OrderPersistencePort;
import order.application.port.in.model.OrderRequest;
import order.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements OrderUsecase {

    private final OrderValidator orderValidator;
    private OrderMapper orderMapper;
    private OrderPersistencePort orderPersistencePort;

//    private OrderDeliveredService orderDeliveredService;
//    private OrderPayedService orderPayedService;

    public OrderService(OrderValidator orderValidator
//                        OrderDeliveredService orderDeliveredService,
//                        OrderPayedService orderPayedService
    ) {
        this.orderValidator = orderValidator;
//        this.orderDeliveredService = orderDeliveredService;
//        this.orderPayedService = orderPayedService;
    }

    @Override
    @Transactional
    public Order placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.mapOrderRequestFrom(orderRequest);
        order.place(orderValidator);
        Order createdOrder = orderPersistencePort.createOrder(order);
        return createdOrder;
    }
//
//    @Transactional
//    public void payOrder(Long orderId) {
//        orderPayedService.payOrder(orderId);
//    }
//
//    @Transactional
//    public void deliverOrder(Long orderId) {
//        orderDeliveredService.deliverOrder(orderId);
//    }
}
