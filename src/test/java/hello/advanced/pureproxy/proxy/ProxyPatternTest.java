package hello.advanced.pureproxy.proxy;

import hello.advanced.pureproxy.proxy.code.CacheSubject;
import hello.advanced.pureproxy.proxy.code.ProxyPatternClient;
import hello.advanced.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheSubject cacheSubject = new CacheSubject(realSubject);
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheSubject);

        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }
}
