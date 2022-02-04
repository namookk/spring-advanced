package hello.advanced.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private final ConcreteLogic logic;

    public TimeProxy(ConcreteLogic logic) {
        this.logic = logic;
    }

    @Override
    public String operation() {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        String result = logic.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("실행시간={}ms", resultTime);
        return result;
    }
}
