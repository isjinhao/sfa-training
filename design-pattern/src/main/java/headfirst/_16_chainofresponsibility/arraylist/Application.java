package headfirst._16_chainofresponsibility.arraylist;

public class Application {

    public static void main(String[] args) {

        HandlerChain chain = new HandlerChain(new Object());
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();

    }
}