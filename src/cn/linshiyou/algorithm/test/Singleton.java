package cn.linshiyou.algorithm.test;

/**
 * @author LJ
 * @create 2023/2/15
 */
public class Singleton {

    private Singleton() {
        System.out.println("........");
    }

    private static class Holder{
        static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return Holder.INSTANCE;
    }

}
