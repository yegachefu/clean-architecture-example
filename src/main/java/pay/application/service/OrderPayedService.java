package pay.application.service;

import org.eternity.food.domain.delivery.Delivery;
import org.eternity.food.domain.delivery.DeliveryRepository;
import org.eternity.food.domain.order.Order;
import org.eternity.food.domain.order.OrderRepository;
import org.eternity.food.domain.shop.ShopRepository;
import org.springframework.stereotype.Component;
import pay.application.port.in.OrderPayedPort;

@Component
public class OrderPayedService implements OrderPayedPort {
    private OrderRepository orderRepository;
    private ShopRepository shopRepository;
    private DeliveryRepository deliveryRepository;

    public OrderPayedService(OrderRepository orderRepository,
                             ShopRepository shopRepository,
                             DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.shopRepository = shopRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void payOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);
        order.payed();

        Delivery delivery = Delivery.started(orderId);
        deliveryRepository.save(delivery);
    }
}
