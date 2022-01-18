package deliver.application.service;

import org.eternity.food.domain.delivery.Delivery;
import org.eternity.food.domain.delivery.DeliveryRepository;
import org.eternity.food.domain.order.Order;
import org.eternity.food.domain.order.OrderRepository;
import org.eternity.food.domain.shop.Shop;
import org.eternity.food.domain.shop.ShopRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderDeliveredService implements org.eternity.food.domain.order.OrderDeliveredService {
    private final OrderRepository orderRepository;
    private final ShopRepository shopRepository;
    private final DeliveryRepository deliveryRepository;

    public OrderDeliveredService(OrderRepository orderRepository,
                                 ShopRepository shopRepository,
                                 DeliveryRepository deliveryRepository) {
        this.orderRepository = orderRepository;
        this.shopRepository = shopRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void deliverOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);
        Shop shop = shopRepository.findById(order.getShopId()).orElseThrow(IllegalArgumentException::new);
        Delivery delivery = deliveryRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);

        order.delivered();
        shop.billCommissionFee(order.calculateTotalPrice());
        delivery.complete();
    }
}
