package org.pang.delivery.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryJpaEntity, Long> {
	Optional<DeliveryJpaEntity> findByOrderId(Long orderId);
}
