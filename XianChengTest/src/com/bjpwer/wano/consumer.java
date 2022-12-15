package com.bjpwer.wano;

import java.util.List;

public class consumer implements Runnable {
    //共有的仓库
    private List list;

    public consumer(List list) {
        this.list = list;
    }


    @Override
    public void run() {
        //一直消费
        while (true){
            synchronized (list){
                //如果等于零说明仓库为空
                if(list.size()==0){
                    //此处线程应进入等待
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
                //仓库执行到这说明有数据,进行消费.
                Object object=list.remove(0);
                System.out.println(Thread.currentThread().getName()+"------>"+object);
                //唤醒生产者生产
                //注意这里的notifyAll并不会唤醒消费者的wait 因为如果上面的wait执行就会直接让该线程睡眠,不会有下面的执行机会
                list.notifyAll();
            }
        }

    }
}
