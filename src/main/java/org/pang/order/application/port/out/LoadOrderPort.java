package org.pang.order.application.port.out;

import org.pang.order.domain.Order;

public interface LoadOrderPort {

	Order loadOrder(Long orderId);

	//payed를 바로 영속성으로 호출하는게 맞을까, 서비스에서 처리하는게 맞을까.
	void payed(Long orderId);

	void update(Order order);
}
