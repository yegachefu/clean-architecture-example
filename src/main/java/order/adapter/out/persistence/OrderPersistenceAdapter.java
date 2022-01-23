package order.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import order.domain.Order;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
