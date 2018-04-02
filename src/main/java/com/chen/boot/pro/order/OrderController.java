package com.chen.boot.pro.order;

import com.chen.boot.pro.req.OrderReq;
import com.chen.boot.pro.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author Chenpz
 * @package com.chen.boot.pro.order
 * @date 2018/3/21/15:16
 */
@RestController
public class OrderController {


	private final OrderService orderService;
	
	@Autowired
	public OrderController (OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@GetMapping("getOrder")
	public Order getOrder(String orderNo){
		return orderService.getOrder(orderNo);
	}
	
	
	
	@PostMapping("createOrder")
	public Order createOrder(@RequestBody OrderReq orderReq){
	
		return Order.builder()
				.orderNo(orderReq.getOrderNo())
				.orderName(orderReq.getOrderName())
				.orderDesc("createOrder")
				.build();
	}
	

}
