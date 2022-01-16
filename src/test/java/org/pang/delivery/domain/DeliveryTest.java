package org.pang.delivery.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DeliveryTest{

	@Test
	public void testCreateDelivery() {
		Long orderId = 10L;

		Delivery delivery = Delivery.started(orderId);

		Assertions.assertThat(delivery).isInstanceOf(Delivery.class);
		Assertions.assertThat(delivery).isNotNull();
		Assertions.assertThat(delivery.getDeliveryStatus()).isEqualTo(Delivery.DeliveryStatus.DELIVERING);
	}
}