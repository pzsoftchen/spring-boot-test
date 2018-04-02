package com.chen.boot.pro.service.impl;

import com.chen.boot.pro.order.Order;
import com.chen.boot.pro.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 *
 * @author Chenpz
 * @package com.chen.boot.pro.service.impl
 * @date 2018/3/29/16:45
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Override
	public Order getOrder (String orderNo) {
		return  Order.builder()
				.orderNo(orderNo)
				.orderName("test")
				.orderDesc("orderDesc")
				.build();
	}
}
