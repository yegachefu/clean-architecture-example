package shop.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.domain.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByShopId(Long shopId);
}
