package com.bjpwer.wano;

import java.util.List;

//生产者线程
public class producer implements Runnable{
    //仓库
    private List list;

    public producer(List list) {
        this.list = list;
    }


    @Override
    public void run() {
        //一直生产（模拟使用死循环一直生产）
        while(true){
            //给产库对象list加锁
            synchronized (list){
                if(list.size()>0){//大于零 说明仓库中有元素了
                    try {
                        //执行此语句 当前线程进入等待状态,并且释放生产之前list占用的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                       //程序能执行到这里说明仓库是空的,可以生产

                }
                Object object =new Object();
                list.add(object);
                System.out.println(Thread.currentThread().getName()+"----->"+object);
                //生产者已执行完毕,唤醒消费者消费
                list.notifyAll();
            }
        }
    }
}
