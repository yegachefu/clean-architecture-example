package org.eternity.food;

import org.eternity.food.domain.generic.money.Money;
import org.eternity.food.service.order.Cart;
import org.eternity.food.service.order.Cart.CartLineItem;
import org.eternity.food.service.order.Cart.CartOption;
import org.eternity.food.service.order.Cart.CartOptionGroup;
import org.eternity.food.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(FoodApplication.class);

    private OrderService orderService;

    public FoodApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        Cart cart = new Cart(1L, 1L,
                        new CartLineItem(1L, "삼겹살 1인세트", 2,
                            new CartOptionGroup("기본",
                                    new CartOption("소(250g)", Money.wons(12000)))));

        orderService.placeOrder(cart); //주문

        orderService.payOrder(1L); //결제

        orderService.deliverOrder(1L); //배송
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(FoodApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
}
