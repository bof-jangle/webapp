package xyz.jangle.demoname.model;

/**
 * 文件存储表 Model
 * @author jangle E-mail: jangle@jangle.xyz
 * @version Jangle生成工具v1.1
 */
public class BsFileBit extends BaseModel {
	
	public static final String tableName = "bs_file_bit";
	/**
	 * 二进制大数据对象
	 */
	private byte[] bitContent;
	
	public byte[] getBitContent(){
		return bitContent;
	}
	public void setBitContent(byte[] bitContent){
		this.bitContent = bitContent;
	}
	
	
}