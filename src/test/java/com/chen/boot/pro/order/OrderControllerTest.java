package com.chen.boot.pro.order;

import com.alibaba.fastjson.JSON;
import com.chen.boot.pro.req.OrderReq;
import com.chen.boot.pro.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * OrderControllerTest
 *
 * @author Chenpz
 * @package com.chen.boot.pro.order
 * @date 2018/3/29/15:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	private OrderController orderController;
	
	@Before
	public void setUp() throws Exception{
		orderController = new OrderController(orderService);
	}
	
	@Test
	public void getOrder1() throws Exception {
		String orderNo = "abc";
		Order order = Order.builder()
				.orderNo("abc")
				.orderName("test")
				.orderDesc("hhh")
				.build();
		when(orderService.getOrder(orderNo)).thenReturn(order);
		Assert.assertThat(order, is(orderController.getOrder("abc")));
	}
	
	@Test
	public void getOrder() throws Exception {
		given(this.orderService.getOrder("abc"))
				.willReturn(Order.builder()
						.orderNo("abc")
						.orderName("test")
						.orderDesc("hhh")
						.build());
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/getOrder?orderNo=abc")
				.accept(MediaType.ALL))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(JSON.toJSONString(Order.builder()
						.orderNo("abc")
						.orderName("test")
						.orderDesc("hhh")
						.build())));
		
	}
	
	@Test
	public void createOrder() throws Exception{
		
		OrderReq orderReq = OrderReq.builder()
				.orderNo("123456")
				.orderName("test")
				.build();
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/createOrder")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(JSON.toJSONString(orderReq))
				.accept(MediaType.APPLICATION_JSON_UTF8)
				).andExpect(MockMvcResultMatchers.status().isOk())
				 .andExpect(MockMvcResultMatchers.content().json(JSON.toJSONString(Order.builder()
						.orderNo("123456")
						.orderName("test")
						.orderDesc("createOrder")
						.build())));

	}
	
	
	

}
