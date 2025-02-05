package ConsumerFunctionalInterface;


import java.util.function.Consumer;

public class ConsumerFiExample {

    public void ConsumerFiStringTest(String input) {

        Consumer<String> consumerString = str -> System.out.println(str);
        consumerString.accept(input);
    }
}
