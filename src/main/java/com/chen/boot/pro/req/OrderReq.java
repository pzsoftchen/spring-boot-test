package com.chen.boot.pro.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderReq
 *
 * @author Chenpz
 * @package com.chen.boot.pro.req
 * @date 2018/3/29/15:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderReq {
	private String orderNo;
	private String orderName;
	
}
