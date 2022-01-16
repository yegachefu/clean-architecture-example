package org.pang.order.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.pang.order.domain.Order;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class OrderJpaEntity {
//	public enum OrderStatus { ORDERED, PAYED, DELIVERED }

	@Id
	@GeneratedValue
	@Column
	private Long id;

	private Long userId;

	private Long shopId;

	private LocalDateTime orderedTime;

	private Order.OrderStatus orderStatus;

	public void payed() {
		this.orderStatus = Order.OrderStatus.PAYED;
	}
}
