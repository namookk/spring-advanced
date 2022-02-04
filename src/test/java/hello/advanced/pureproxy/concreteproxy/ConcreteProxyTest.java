package hello.advanced.pureproxy.concreteproxy;

import hello.advanced.pureproxy.concreteproxy.code.ConcreteClient;
import hello.advanced.pureproxy.concreteproxy.code.ConcreteLogic;
import hello.advanced.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic logic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(logic);
        client.execute();
    }
    @Test
    void proxy() {
        ConcreteLogic logic = new ConcreteLogic();
        TimeProxy timelogic = new TimeProxy(logic);
        ConcreteClient client = new ConcreteClient(timelogic);
        client.execute();
    }
}
