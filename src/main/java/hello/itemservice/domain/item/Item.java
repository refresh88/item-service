package hello.itemservice.domain.item;

import lombok.Data;

@Data // 예제용이니까 쓰지만 어지간하면 필요한걸 따로 불러 쓰는걸 추천.
public class Item {

    private Long id;
    private String itemName;
    private Integer price;      // Integer 쓰는 이유는 가격이 null일수도 있기 떄문.
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) { // Id를 제외한 생성자
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
