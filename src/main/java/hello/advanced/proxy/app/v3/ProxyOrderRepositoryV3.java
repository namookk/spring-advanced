package hello.advanced.proxy.app.v3;

import org.springframework.stereotype.Repository;

@Repository
public class ProxyOrderRepositoryV3 {
    public void save(String itemId) {
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
