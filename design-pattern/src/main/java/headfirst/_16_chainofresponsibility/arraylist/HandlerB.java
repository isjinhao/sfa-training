package headfirst._16_chainofresponsibility.arraylist;

public class HandlerB implements IHandler {

    @Override
    public boolean handle(Object object) {
        boolean handled = false;
        System.out.println("HandlerB is invoked");
        return handled;
    }
}