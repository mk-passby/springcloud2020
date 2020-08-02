package com.bli.guigu.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

public interface LoadBalancer {
    /**
     * 收集服务器总共有多少台能够提供服务的机器，并放到list里面
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
