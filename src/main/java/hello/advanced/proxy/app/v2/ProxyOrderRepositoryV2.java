package hello.advanced.proxy.app.v2;

public class ProxyOrderRepositoryV2 {
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
