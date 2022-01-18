package order.application.port.in;

import order.domain.Cart;

public interface OrderPort {
    void placeOrder(Cart cart);
}
