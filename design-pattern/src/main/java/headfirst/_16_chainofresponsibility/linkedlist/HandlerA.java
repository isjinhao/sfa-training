package headfirst._16_chainofresponsibility.linkedlist;

public class HandlerA extends Handler {

    @Override
    protected boolean doHandle(Object object) {
        boolean handled = false;
        /**
         * ...
         */
        System.out.println("HandlerA is invoked");
        return handled;
    }
}