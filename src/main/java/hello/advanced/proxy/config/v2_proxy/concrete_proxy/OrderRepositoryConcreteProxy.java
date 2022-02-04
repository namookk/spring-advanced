package hello.advanced.proxy.config.v2_proxy.concrete_proxy;

import hello.advanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends ProxyOrderRepositoryV2 {

    private final ProxyOrderRepositoryV2 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.save()");
            //target호출
            target.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
