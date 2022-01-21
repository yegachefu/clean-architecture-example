package order.adapter.in.web;

import order.adapter.in.web.model.CartRequest;
import order.adapter.in.web.model.OrderResponse;
import order.application.port.in.model.OrderRequest;
import order.domain.Order;
import order.domain.OrderLineItem;
import order.domain.OrderOption;
import order.domain.OrderOptionGroup;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class OrderWebMapper {

    public OrderRequest mapOrderRequestFrom(CartRequest cart) {
        return new OrderRequest(
                cart.getUserId(),
                cart.getShopId(),
                cart.getCartLineItems()
                        .stream()
                        .map(this::toOrderLineItem)
                        .collect(toList()),
                LocalDateTime.now(), null);
    }

    public OrderResponse mapOrderResponseFrom(Order order) {
        return new OrderResponse(
                order.getShopId(),
                order.getOrderLineItems(),
                order.getOrderedTime()
        );
    }

    private OrderLineItem toOrderLineItem(CartRequest.CartLineItem cartLineItem) {
        return new OrderLineItem(
                cartLineItem.getMenuId(),
                cartLineItem.getName(),
                cartLineItem.getCount(),
                cartLineItem.getGroups()
                        .stream()
                        .map(this::toOrderOptionGroup)
                        .collect(Collectors.toList()));
    }

    private OrderOptionGroup toOrderOptionGroup(CartRequest.CartOptionGroup cartOptionGroup) {
        return new OrderOptionGroup(
                cartOptionGroup.getName(),
                cartOptionGroup.getOptions()
                        .stream()
                        .map(this::toOrderOption)
                        .collect(Collectors.toList()));
    }

    private OrderOption toOrderOption(CartRequest.CartOption cartOption) {
        return new OrderOption(
                cartOption.getName(),
                cartOption.getPrice());
    }
}
