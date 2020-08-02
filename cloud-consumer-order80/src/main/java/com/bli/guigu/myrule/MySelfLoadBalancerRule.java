package com.bli.guigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springcloud2020
 * @description: 自定义负载均衡
 * @author: mk_passby
 * @create: 2020-08-02 14:28
 **/
public class MySelfLoadBalancerRule extends AbstractLoadBalancerRule {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = this.getLoadBalancer();
        List<Server> serverList = lb.getReachableServers();
        Server server = null;
        if (serverList != null && serverList.size() > 0) {
            server = serverList.get(getIndex(serverList.size()));
        }
        atomicInteger.incrementAndGet();
        return server;
    }

    /**
     * 处理int越界
     * @param serverCount
     * @return
     */
    private int getIndex(int serverCount) {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current == Integer.MAX_VALUE ? 2 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        return atomicInteger.get() / 3 % serverCount;
    }
}
