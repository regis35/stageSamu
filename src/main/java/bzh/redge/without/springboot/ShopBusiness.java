package bzh.redge.without.springboot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ShopBusiness {

    private ShopDao shopDao;

    public Shop create(Shop shop) {
        if (shop.getName().isEmpty()) {
            log.info("The name shop is empty");
            return null;
        }
        return shopDao.create(shop);
    }

    public void remove(Shop shop) {
        Shop shopTmp;
        if (shop.getId() == null) {
            shopTmp = shopDao.findByName(shop.getName());
        } else {
            shopTmp = shop;
        }
        shopDao.remove(shopTmp);

    }

}
