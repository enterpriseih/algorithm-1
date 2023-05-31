package cn.linshiyou.algorithm.designModel.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyou.lin
 * @date 2023/5/31
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
