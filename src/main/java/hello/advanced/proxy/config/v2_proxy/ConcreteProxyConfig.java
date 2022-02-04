package hello.advanced.proxy.config.v2_proxy;

import hello.advanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.advanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.advanced.proxy.app.v2.ProxyOrderServiceV2;
import hello.advanced.proxy.config.v2_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.advanced.proxy.config.v2_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import hello.advanced.proxy.config.v2_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public ProxyOrderControllerV2 proxyOrderController2(LogTrace logTrace) {
        ProxyOrderControllerV2 target = new ProxyOrderControllerV2(proxyOrderService2(logTrace));
        return new OrderControllerConcreteProxy(target, logTrace);
    }

    @Bean
    public ProxyOrderServiceV2 proxyOrderService2(LogTrace logTrace) {
        ProxyOrderServiceV2 target = new ProxyOrderServiceV2(proxyOrderRepository2(logTrace));
        return new OrderServiceConcreteProxy(target, logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV2 proxyOrderRepository2(LogTrace logTrace){
        ProxyOrderRepositoryV2 target = new ProxyOrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(target, logTrace);
    }
}
