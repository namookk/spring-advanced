package hello.advanced.proxy.config.v1_proxy.interface_proxy;

import hello.advanced.proxy.app.v1.ProxyOrderRepositoryV1;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements ProxyOrderRepositoryV1 {
    private final ProxyOrderRepositoryV1 target;
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
