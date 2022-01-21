package order.adapter.out.persistence;

import order.domain.Order;

public interface OrderPersistencePort {
    Order createOrder(Order order);
}
