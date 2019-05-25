package xyz.jangle.demoname.dao;

import xyz.jangle.demoname.model.BsUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.jangle.demoname.model.BsUserExample;

public interface BsUserMapper extends BaseDaoMapper<BsUser>{
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	long countByExample(BsUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int deleteByExample(BsUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int deleteByPrimaryKey(Integer usrId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int insert(BsUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int insertSelective(BsUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	List<BsUser> selectByExample(BsUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	BsUser selectByPrimaryKey(Integer usrId);
	/**
	 * 根据code和password查询用户
	 * @param record
	 * @return
	 */
	BsUser selectByCodeAndPassword(BsUser record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByExampleSelective(@Param("record") BsUser record, @Param("example") BsUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByExample(@Param("record") BsUser record, @Param("example") BsUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByPrimaryKeySelective(BsUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table bs_user
	 * @mbg.generated  Tue Sep 18 11:02:25 CST 2018
	 */
	int updateByPrimaryKey(BsUser record);

	/**
	 * 保存
	 * @return
	 */
	int save(BsUser bsUser);
	/**
	 * 修改状态
	 * @param bsUser
	 * @return
	 */
	int updateStatusById(BsUser bsUser);

}
