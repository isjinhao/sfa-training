package headfirst._16_chainofresponsibility.linkedlist;

public class HandlerChain {

    private Object object;

    public HandlerChain(Object object) {
        this.object = object;
    }

    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle(object);
        }
    }
}