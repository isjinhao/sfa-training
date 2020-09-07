package headfirst._16_chainofresponsibility.linkedlist;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/23
 */
public class HandlerC extends Handler {

    @Override
    protected boolean doHandle(Object object) {
        boolean handled = false;
        System.out.println("HandlerC is invoked");
        return handled;
    }
}
