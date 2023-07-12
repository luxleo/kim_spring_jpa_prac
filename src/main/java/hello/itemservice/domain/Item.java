package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // JPA에서 테이블과 매핑하여 관리한다
//@Table(name = "item") 테이블 이름도 지정 가능하다. 단 같으면 생략가능
public class Item {

    @Id // primary key로 사용됨을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk를 db에서 할당해줌(auto_increment)
    private Long id;

    @Column(name = "item_name",length = 10) // 컬럼 명과 제약조건 설정 이때 컬럼명은 미지정시 필드 이름과 동일
    private String itemName;
    private Integer price;
    private Integer quantity;

    // JPA를 사용하기 위해서는 기본 생성자가 필수적으로 정의 되어있어야한다.
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
