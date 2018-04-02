package com.chen.boot.pro.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 *
 * @author Chenpz
 * @package com.chen.boot.pro.order
 * @date 2018/3/21/15:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private String orderNo;
	private String orderName;
	private String orderDesc;
}
