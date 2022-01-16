package org.pang.delivery.adapter.out;

import lombok.RequiredArgsConstructor;
import org.pang.delivery.application.port.out.LoadDeliveryPort;
import org.pang.delivery.domain.Delivery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@RequiredArgsConstructor
public class DeliveryPersistenceAdapter implements LoadDeliveryPort {

	private final DeliveryJpaRepository deliveryJpaRepository;

	@Override
	public Delivery loadDeliveryByOrderId(Long orderId) {
		DeliveryJpaEntity jpaEntity = deliveryJpaRepository.findByOrderId(orderId).orElseThrow(EntityNotFoundException::new);
		return DeliveryMapper.toDomainEntity(jpaEntity);
	}

	@Override
	public void save(Delivery delivery) {
		DeliveryJpaEntity jpaEntity = DeliveryMapper.toJpaEntity(delivery);
		deliveryJpaRepository.save(jpaEntity);
	}

	@Override
	public void update(Delivery delivery) {
		DeliveryJpaEntity jpaEntity = DeliveryMapper.toJpaEntity(delivery);
		if (jpaEntity.getId() != null) {
			deliveryJpaRepository.save(jpaEntity);
		}
	}
}
