package hello.advanced.proxyfactory;

import hello.advanced.common.advice.TimeAdvice;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProxyFactoryTest {

    @Test
    void interfaceProxy() {
//        ServiceInterface target = new ServiceImpl();
//        ProxyFactory factory = new ProxyFactory(target);
//        factory.addAdvice(new TimeAdvice());
//        ServiceInterface proxy = (ServiceInterface)ProxyFactory.getProxy();
//
//        log.info("target.class={}", target.getClass());
//        log.info("proxy.class={}", proxy.getClass());
//
//        proxy.save();
//        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
//        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
//        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }
}
