package io.bruce.mq.job;

import io.bruce.mq.entity.Order;
import io.bruce.mq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class OrderJob {

    @Autowired
    private OrderMapper orderMapper;

    @Scheduled(cron = "1/1 * * * * ?")
    public void handleOrder() {
        List<Order> list = orderMapper.getUnHandleOrder();
        if(!CollectionUtils.isEmpty(list)){
            for (Order order : list) {
                order.setStatus(1);
                orderMapper.updateOrderStatus(order);
                System.out.println("handle order, order-id: " + order.getId());
            }
        }else{
//            System.out.println("no data to handle");
        }
    }

}
