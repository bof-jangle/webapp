package xyz.jangle.demoname.model;
/** 
* @author jangle E-mail: jangle@jangle.xyz
* @version 2019年1月18日 下午12:35:11 
* 类说明 
*/
public abstract class BaseModel {
	/**
	 * 页码
	 */
	private Integer pageNum = 0;
	/**
	 * 页宽
	 */
	private Integer pageSize = 10;
	/**
	 * 起始索引 用于Mysql的分页 limit pageStart, pageSize
	 */
	private Long pageStart = 1L;
	
	/**
	 * 字段排序
	 */
	private String orderByJ;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageStart() {
		return pageStart;
	}

	public void setPageStart(Long pageStart) {
		this.pageStart = pageStart;
	}

	public String getOrderByJ() {
		return orderByJ;
	}

	public void setOrderByJ(String orderByJ) {
		this.orderByJ = orderByJ;
	}
	
	
	
	
	
}
