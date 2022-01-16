package org.pang.delivery.adapter.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pang.delivery.domain.Delivery;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "delivery")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private Long id;

	@Column(name = "ORDER_ID")
	private Long orderId;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Delivery.DeliveryStatus deliveryStatus;
}
