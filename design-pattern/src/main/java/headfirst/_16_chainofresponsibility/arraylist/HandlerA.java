package headfirst._16_chainofresponsibility.arraylist;

public class HandlerA implements IHandler {

    @Override
    public boolean handle(Object object) {
        boolean handled = false;
        System.out.println("HandlerA is invoked");
        return handled;
    }
}