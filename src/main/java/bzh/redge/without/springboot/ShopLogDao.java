package bzh.redge.without.springboot;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ShopLogDao implements ShopDao {

    @Override
    public Shop create(Shop myShop) {
        log.info("create new shop in my storage");
        myShop.setId(UUID.randomUUID());
        return myShop;
    }

    @Override
    public void remove(Shop myShop) {
        log.info("remove shop -> {}", myShop);
    }

    @Override
    public Shop findByName(String shopName) {
        return Shop.builder()
                .id(UUID.randomUUID())
                .name(shopName)
                .build();
    }
}
