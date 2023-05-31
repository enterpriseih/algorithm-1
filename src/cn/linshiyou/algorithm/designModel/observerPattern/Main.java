package cn.linshiyou.algorithm.designModel.observerPattern;

/**
 * 观察者模式
 *
 * @author shiyou.lin
 * @date 2023/5/31
 */

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1", subject);
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2", subject);

        subject.attach(observer1);
        subject.attach(observer2);
        subject.notifyObservers();

        subject.detach(observer1);
        subject.notifyObservers();
    }
}