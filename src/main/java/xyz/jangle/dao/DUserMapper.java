package xyz.jangle.dao;

import xyz.jangle.model.DUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.jangle.model.DUserExample;

public interface DUserMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	long countByExample(DUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int deleteByExample(DUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int deleteByPrimaryKey(Integer usrId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int insert(DUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int insertSelective(DUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	List<DUser> selectByExample(DUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	DUser selectByPrimaryKey(Integer usrId);
	/**
	 * 根据code和password查询用户
	 * @param record
	 * @return
	 */
	DUser selectByCodeAndPassword(DUser record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByExampleSelective(@Param("record") DUser record, @Param("example") DUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByExample(@Param("record") DUser record, @Param("example") DUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByPrimaryKeySelective(DUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByPrimaryKey(DUser record);

	/**
	 * 保存
	 * @return
	 */
	int save(DUser dUser);

}
