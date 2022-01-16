package org.pang.order.application;

import lombok.RequiredArgsConstructor;
import org.pang.delivery.application.port.out.LoadDeliveryPort;
import org.pang.delivery.domain.Delivery;
import org.pang.order.application.port.in.OrderPayedUseCase;
import org.pang.order.application.port.out.LoadOrderPort;
import org.pang.order.domain.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPayedService implements OrderPayedUseCase {

	private final LoadOrderPort loadOrderPort;
	private final LoadDeliveryPort loadDeliveryPort;

	@Override
	public void payOrdered(Long orderId) {
		Order order = loadOrderPort.loadOrder(orderId);
		Delivery delivery = Delivery.started(order.getOrderId());
		loadDeliveryPort.save(delivery);
	}

	@Override
	public void deliverOrder(Long orderId) {
		Order order = loadOrderPort.loadOrder(orderId);
		//load shop
		Delivery delivery = loadDeliveryPort.loadDeliveryByOrderId(orderId);

		order.delivered();
		delivery.complete();

		loadOrderPort.update(order);
		loadDeliveryPort.update(delivery);
	}
}
