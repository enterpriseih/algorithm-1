package cn.linshiyou.algorithm.designModel.observerPattern;

/**
 * @author shiyou.lin
 * @date 2023/5/31
 */
public class ConcreteObserver implements Observer {
    private String name;
    private Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void update() {
        System.out.println(name + " received a notification.");
    }
}