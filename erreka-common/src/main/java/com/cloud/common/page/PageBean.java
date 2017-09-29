package com.cloud.common.page;

import java.util.List;

import com.github.pagehelper.Page;

import lombok.Data;

@Data
public class PageBean<T, M> {
	
	/** 当前页码 */
	private Integer pageNum;
	/** 每页数量 */
	private Integer pageSize;
	/** 总数 */
	private Long total;
	/** 总页数 */
	private Integer pages;
	/** 返回数据 */
	private List<T> list;
	
	/** 是否第一页 */
	private boolean firstPage;
	/** 是否最后一页 */
	private boolean lastPage;
	/** 是否有上一页 */
	private boolean hasPreviousPage;
	/** 是否有下一页 */
	private boolean hasNextPage;
	
	public PageBean() {
		super();
	}

	public PageBean(List<T> target, List<M> src) {
		super();
		if (src instanceof Page) {
			Page<M> page = (Page<M>) src;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.list = target;
			if (this.pageNum == 1) {
				this.firstPage = true;
				this.hasPreviousPage = false;
			} else {
				this.firstPage = false;
				this.hasPreviousPage = true;
			}
			if (this.pageNum.equals(this.pages)) {
				this.lastPage = true;
				this.hasNextPage = false;
			} else {
				this.lastPage = false;
				this.hasNextPage = true;
			}
		}
	}
	
}
