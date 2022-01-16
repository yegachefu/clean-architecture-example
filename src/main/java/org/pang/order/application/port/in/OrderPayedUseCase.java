package org.pang.order.application.port.in;

public interface OrderPayedUseCase {

	void payOrdered(Long orderId);

	void deliverOrder(Long orderId);
}
