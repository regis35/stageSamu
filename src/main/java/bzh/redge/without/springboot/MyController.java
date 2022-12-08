package bzh.redge.without.springboot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class MyController {

    private ShopBusiness shopBusiness;
    private OtherBusiness otherBusiness;


    public void entryPoint(Shop shop) {
        log.info("[entryPoint] start");
        otherBusiness.something();
        log.info("[entryPoint] middle");
        shopBusiness.create(shop);
        log.info("[entryPoint] stop");

    }




}
