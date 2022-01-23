//package config;
//
//import order.adapter.out.persistence.OrderPersistenceAdapter;
//import order.adapter.out.persistence.OrderRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@EnableJpaRepositories
//public class PersistenceAdapterConfiguration {
//
//    @Bean
//    OrderPersistenceAdapter orderPersistenceAdapter(
//            OrderRepository orderRepository
//    ) {
//        return new OrderPersistenceAdapter(
//                orderRepository
//        );
//    }
//
//}
