package headfirst._16_chainofresponsibility.linkedlist;

public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(Object object) {
        boolean handled = doHandle(object);

        /**
         * 沿着handler链一直处理到末尾
         */
//        if (successor != null) {

        /**
         * 处理到某个handler截止
         */
        if (successor != null && !handled) {
            successor.handle(object);
        }
    }

    protected abstract boolean doHandle(Object object);
}