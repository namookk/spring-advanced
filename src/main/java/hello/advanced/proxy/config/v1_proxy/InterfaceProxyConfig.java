package hello.advanced.proxy.config.v1_proxy;

import hello.advanced.proxy.app.v1.*;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.advanced.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public ProxyOrderControllerV1 proxyOrderController(LogTrace logTrace) {
        ProxyOrderControllerV1Impl target = new ProxyOrderControllerV1Impl(proxyOrderService(logTrace));
        return new OrderControllerInterfaceProxy(target, logTrace);
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderService(LogTrace logTrace) {
        ProxyOrderServiceV1Impl target = new ProxyOrderServiceV1Impl(proxyOrderRepository(logTrace));
        return new OrderServiceInterfaceProxy(target, logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepository(LogTrace logTrace){
        ProxyOrderRepositoryV1Impl target = new ProxyOrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(target, logTrace);
    }
}
