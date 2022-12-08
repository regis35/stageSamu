package bzh.redge.without.springboot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        // Init partie framework
        ShopDao shopDao = new ShopMemoryDao();
        ShopBusiness sb = new ShopBusiness(shopDao);
        OtherBusiness otherBusiness = new OtherBusinessImpl();
        MyController controller = new MyController(sb,otherBusiness);




        Shop myShop1 = Shop.builder()
                .name("mon shop")
                .address("Rennes")
                .build();

        controller.entryPoint(myShop1);

        Shop myShop2 = Shop.builder()
                .name("mon shop")
                .address("Quimper")
                .build();

        Shop myShop3 = Shop.builder()
                .name("mon shop n°3")
                .address("Brest")
                .build();

        Shop tmp = sb.create(myShop1);
        log.info("1-{}>", tmp);

         tmp = sb.create(myShop2);
        log.info("1-{}>", tmp);

        tmp = sb.create(myShop3);
        log.info("1-{}>", tmp);

    }
}
