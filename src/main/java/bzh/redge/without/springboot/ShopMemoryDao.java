package bzh.redge.without.springboot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopSystemOutDao implements ShopDao {

    @Override
    public Shop create(Shop myShop) {
        System.out.println("create new shop in my storage");
        return myShop;
    }

    @Override
    public void remove(Shop myShop) {
        System.out.println("remove shop -> "+ myShop);
    }

    @Override
    public Shop findByName(String shopName) {
        return Shop.builder()
                .name(shopName)
                .build();
    }
}
