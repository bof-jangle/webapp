package xyz.jangle.demoname.service.impl;

//import java.util.List;

//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;

//import xyz.jangle.demoname.dao.BsDemoMapper;
import xyz.jangle.demoname.model.BaseModel;
//import xyz.jangle.utils.CME;
//import xyz.jangle.utils.ResultModel;

/**
 * 服务层基类，用于定义一些通用属性。
 * 
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月18日 下午3:19:16 类说明
 */
public abstract class BaseServiceImpl<T extends BaseModel> {
	
//	@Autowired
//	SqlSessionFactory sqlSessionFactory;

	protected Logger logger = Logger.getLogger(getClass());
	
//	@SuppressWarnings("unchecked")
//	public ResultModel<T> selectByPrimaryKey(T record) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		sqlSession.getMapper(BsDemoMapper.class);
//		/*try {
//			BsDemoMapper bsDemoMapper = (BsDemoMapper) sqlSession.getMapper(Class.forName("xyz.jangle.demoname.dao.BsDemoMapper"));
//			record = (T) bsDemoMapper.selectByPrimaryKey(record.getId());
//			return new ResultModel<T>(record);
//		} catch (ClassNotFoundException e) {
//			logger.info(e);
//			ResultModel<T> resultModel = new ResultModel<T>(CME.exception);
//			resultModel.appendMessage(e.toString());
//			return resultModel;
//		}*/
//		System.out.println(record.getClass());
//		System.out.println(record.getClass().getSimpleName());
//		List<Object> selectList = sqlSession.selectOne("xyz.jangle.demoname.dao."+record.getClass().getSimpleName()+"Mapper.selectByPrimaryKey", record);
//		System.out.println(selectList.size());
//		record = (T) selectList.get(0);
//		return new ResultModel<T>(record);
//	}

}
