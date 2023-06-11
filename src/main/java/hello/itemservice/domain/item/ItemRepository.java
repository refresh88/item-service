package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // ComponentScan의 대상이됨.
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static, 동시성 문제로 HashMap은 별로.
    private static long sequence = 0L; // static, 얘도 동시성 문제로 atomic을 사용해야함 확인해볼것.

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() { // HashMap 데이터 날리기용. 테스트 위해서.
        store.clear();
    }
}
