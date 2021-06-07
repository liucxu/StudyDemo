public class MainTest {
    public static void main(String[] args){
        Generator<Number> numberGenerator=new Generator<>(123);
        Generator<Integer> integerGenerator=new Generator<>(456);
        getGenerator(integerGenerator);
        getGenerate(numberGenerator);
        println("liucx","zhangll","sqliu");
    }
    private static void getGenerator(Generator<?> numberGenerator){
        System.out.println(numberGenerator.getKey()+"");
    }

    private static <T extends Number> T getGenerate(Generator<T> container){
        System.out.println(container.getKey());
        return container.getKey();
    }

    private static <T> void println(T...args){
        for(T arg:args){
            System.out.println(arg);
        }
    }
}
