package headfirst._16_chainofresponsibility.linkedlist;

public class HandlerB extends Handler {

    @Override
    protected boolean doHandle(Object object) {
        boolean handled = false;
        System.out.println("HandlerB is invoked");
        return handled;
    }
}