package org.pang.delivery.adapter.out;

import org.pang.delivery.domain.Delivery;

public class DeliveryMapper {

	static DeliveryJpaEntity toJpaEntity(Delivery delivery) {
		return new DeliveryJpaEntity(
				delivery.getId(),
				delivery.getOrderId(),
				delivery.getDeliveryStatus()
		);
	}

	public static Delivery toDomainEntity(DeliveryJpaEntity entity) {
		return new Delivery(
				entity.getId(),
				entity.getOrderId(),
				entity.getDeliveryStatus());
	}
}
