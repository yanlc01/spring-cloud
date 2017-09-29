package com.cloud.common.page;

import lombok.Data;

@Data
public class PageCondition {

	private Integer pageNum = 1;
	
	private Integer pageSize = 10;
	
}
