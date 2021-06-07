public class Generator <T extends Number> {
    private T key;
    public Generator(T key){
        this.key=key;
    }
    public T getKey(){
        return key;
    }
}
