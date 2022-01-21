package order.adapter.out.persistence;

import order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
