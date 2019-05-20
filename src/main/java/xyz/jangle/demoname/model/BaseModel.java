package xyz.jangle.demoname.model;

/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月18日 类说明
 */
public abstract class BaseModel {

	private Long id;
	/**
	 * id字符串集合
	 */
	private String ids;
	/**
	 * UUID字符串集合
	 */
	private String uuids;
	/**
	 * id数组集合
	 */
	private String[] idsArray;
	/**
	 * UUID数组集合
	 */
	private String[] uuidsArray;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getUuids() {
		return uuids;
	}

	public void setUuids(String uuids) {
		this.uuids = uuids;
	}

	public String[] getIdsArray() {
		return idsArray;
	}

	public void setIdsArray(String[] idsArray) {
		this.idsArray = idsArray;
	}

	public String[] getUuidsArray() {
		return uuidsArray;
	}

	public void setUuidsArray(String[] uuidsArray) {
		this.uuidsArray = uuidsArray;
	}
	
	

}
