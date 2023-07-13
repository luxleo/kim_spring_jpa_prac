package hello.itemservice.config;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.jpa.JpaItemRepositoryV3;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * 컴파일 시점에 컴파일 될 jpql의 문제 상태를 잡아 낼수있다.
 * + 동적 쿼리가 무지하게 깔끔해지고 쉬워지고 컴파일 시점에 잡아낸다.
 */
@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

    private final EntityManager em;
    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {

        return new JpaItemRepositoryV3(em);
    }

}
