package xyz.jangle.utils;

import org.mybatis.generator.internal.DefaultCommentGenerator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
/**
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年1月15日 下午3:50:08 类说明
 */
public class JangleCommentGenerator extends DefaultCommentGenerator {
		
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
			field.addJavaDocLine("/**");
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
			addJavadocTag(field, false);
			field.addJavaDocLine(" */");
		}
	}

}
