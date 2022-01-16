package org.pang.order.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.pang.order.application.port.out.LoadOrderPort;
import org.pang.order.domain.Order;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements LoadOrderPort {

	private final OrderJpaRepository orderJpaRepository;

	@Override
	public Order loadOrder(Long orderId) {
		OrderJpaEntity order = findOrder(orderId);
		return OrderMapper.toDomainEntity(order);
	}

	@Override
	public void payed(Long orderId) {
		OrderJpaEntity order = findOrder(orderId);
		order.payed();
	}

	@Override
	public void update(Order order) {
		OrderJpaEntity jpaEntity = OrderMapper.toJpaEntity(order);
		if(jpaEntity.getId() != null){
			orderJpaRepository.save(jpaEntity);
		}
	}


	private OrderJpaEntity findOrder(Long orderId) {
		return orderJpaRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
	}
}
