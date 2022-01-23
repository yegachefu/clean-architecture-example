package order.application.port.in;

import order.application.port.in.model.OrderRequest;
import order.domain.Order;

public interface OrderUsecase {
    Order placeOrder(OrderRequest order);
}
