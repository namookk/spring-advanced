package hello.advanced.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheSubject implements Subject{
    private Subject target;
    private String cacheData;

    public CacheSubject(Subject target){
        this.target = target;
    }

    public CacheSubject() {

    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if(cacheData == null) {
            cacheData = target.operation();
        }
        return cacheData;
    }
}
