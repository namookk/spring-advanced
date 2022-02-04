package hello.advanced.proxy.config.v2_proxy.concrete_proxy;

import hello.advanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerConcreteProxy extends ProxyOrderControllerV2 {
    private final ProxyOrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy( ProxyOrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderController.request()");
            //target호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
