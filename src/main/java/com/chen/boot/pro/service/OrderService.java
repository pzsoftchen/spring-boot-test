package com.chen.boot.pro.service;

import com.chen.boot.pro.order.Order;

/**
 * OrderService
 *
 * @author Chenpz
 * @package com.chen.boot.pro.service
 * @date 2018/3/29/16:45
 */
public interface OrderService {
	
	Order getOrder(String orderNo);
	
}
