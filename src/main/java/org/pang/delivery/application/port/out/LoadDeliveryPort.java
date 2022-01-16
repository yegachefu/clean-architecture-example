package org.pang.delivery.application.port.out;

import org.pang.delivery.domain.Delivery;

public interface LoadDeliveryPort {
	Delivery loadDeliveryByOrderId(Long orderId);
	void save(Delivery delivery);

	void update(Delivery delivery);
}
