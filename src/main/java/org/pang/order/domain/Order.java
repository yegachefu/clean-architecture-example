package org.pang.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {

	private Long orderId;
	private Long userId;
	private Long shopId;
	private LocalDateTime orderedTime;
	private OrderStatus status;

	public void delivered() {
		this.status = OrderStatus.DELIVERED;
	}

	public enum OrderStatus {ORDERED, PAYED, DELIVERED}
}
