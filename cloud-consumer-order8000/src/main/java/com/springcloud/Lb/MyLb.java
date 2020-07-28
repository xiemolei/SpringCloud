package com.springcloud.Lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : xiemogaminari
 * create at:  2020-05-27  16:24
 * @description: a
 */
@Component
public class MyLb  implements Loadbalance {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public final  int getIncrement() {
        int current;
        int next;
        do{
            current=atomicInteger.get();
            next=current>=2147483647?0:current+1;
        }while (!atomicInteger.weakCompareAndSet(current,next));
        System.out.println("第几次访问数，next:"+next);
        return next;
    }

    public ServiceInstance getServiceInstance(List<ServiceInstance> list){
        int index=getIncrement()%list.size();
        return list.get(index);
    }
}