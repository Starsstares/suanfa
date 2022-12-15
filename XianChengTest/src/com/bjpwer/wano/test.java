package com.bjpwer.wano;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //创建一个仓库对象,共享的
        List list =new ArrayList();
        //创建两个线程对象
        //生产者线程
        Thread t1=new Thread(new producer(list));
        //消费者线程
        Thread t2=new Thread(new consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();

    }
}
