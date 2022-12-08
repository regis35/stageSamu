package bzh.redge.without.springboot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherBusinessImpl implements OtherBusiness{
    @Override
    public void something() {
        log.info("nothing to do");
    }
}
