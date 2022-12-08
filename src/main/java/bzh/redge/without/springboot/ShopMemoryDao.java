package bzh.redge.without.springboot;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class ShopMemoryDao implements ShopDao {

    private Map<String, Shop> memory = new HashMap<>(5);

    @Override
    public Shop create(Shop myShop) {
        if (memory.containsKey(myShop.getName())) {
            log.info("[shop:{} -> is already exist]", myShop.getName());
            return memory.get(myShop.getName());
        }
        log.info("[shop:{} -> persist]", myShop.getName());
        myShop.setId(UUID.randomUUID());
        memory.put(myShop.getName(), myShop);

        return myShop;
    }

    @Override
    public void remove(Shop myShop) {
        if (!memory.containsKey(myShop.getName())) {
            log.info("[shop:{} -> not found]", myShop.getName());
            return;
        }
        log.info("[shop:{} -> remove]", myShop.getName());
        memory.remove(myShop.getName());
    }

    @Override
    public Shop findByName(String shopName) {
        if (memory.containsKey(shopName)) {
            log.info("[shop:{} -> find]", shopName);
            return memory.get(shopName);
        }
       return null;
    }
}
