package bzh.redge.without.springboot;

public interface ShopDao {

     Shop create(Shop myShop);

     void remove(Shop myShop);

     Shop findByName(String shopName);

}
