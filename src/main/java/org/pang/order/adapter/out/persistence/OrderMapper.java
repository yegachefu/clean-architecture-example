package org.pang.order.adapter.out.persistence;

import org.pang.order.domain.Order;

public class OrderMapper {

	static Order toDomainEntity(OrderJpaEntity entity) {
		return new Order(
				entity.getId(),
				entity.getUserId(),
				entity.getShopId(),
				entity.getOrderedTime(),
				entity.getOrderStatus() // enum 클래스는 매핑시 어떻게 해야할까?
		);
	}

	static OrderJpaEntity toJpaEntity(Order domainEntity) {
		return new OrderJpaEntity(
				domainEntity.getOrderId(),
				domainEntity.getUserId(),
				domainEntity.getShopId(),
				domainEntity.getOrderedTime(),
				domainEntity.getStatus()
		);
	}
}
