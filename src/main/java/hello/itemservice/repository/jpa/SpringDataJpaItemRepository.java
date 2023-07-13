package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByItemNameLike(String itemName);

    List<Item> findByPriceLessThanEqual(Integer price);

    //쿼리 메서드 (조회 조건이 길게 붙으면 비효율적이다
    List<Item> findByItemNameLikeAndPriceLessThan(String itemName, Integer price);

    // 그래서 직접 쿼리를 실행하자 ㅎㅎ
    @Query("select i from Item i where i.itemName like :itemName and i.price<=:price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);



}
