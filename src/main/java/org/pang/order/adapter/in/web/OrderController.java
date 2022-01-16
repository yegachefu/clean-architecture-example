package org.pang.order.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.pang.order.application.port.in.OrderPayedUseCase;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OrderController {
	private final OrderPayedUseCase orderPayedUseCase;

	public void orderPayed(Long orderId){
		orderPayedUseCase.payOrdered(orderId);
	}

	public void deliverOrder(Long orderId){
		orderPayedUseCase.deliverOrder(orderId);
	}
}
