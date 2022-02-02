package hello.advanced.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping("/proxy") // 스프링은 @Controller 또는 @RequestMapping 어노테이션이 있어야 스프링 컨트롤러로 인식할 수 있다.
@ResponseBody
public class ProxyOrderControllerV2 {

    private final ProxyOrderServiceV2 orderService;

    public ProxyOrderControllerV2(ProxyOrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}
