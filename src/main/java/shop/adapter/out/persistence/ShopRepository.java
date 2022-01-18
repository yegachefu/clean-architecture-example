package shop.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.domain.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
