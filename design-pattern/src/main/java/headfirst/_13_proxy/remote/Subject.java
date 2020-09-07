package headfirst._13_proxy.remote;

/**
 * Created by Gavin on 2017/2/13.
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
