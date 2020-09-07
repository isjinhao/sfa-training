package headfirst._16_chainofresponsibility.arraylist;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

    private Object object;

    public HandlerChain(Object object) {
        this.object = object;
    }

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle(object);
            if (handled) {
                break;
            }
        }
    }
}