package org.springboot.multi.demo.common;

public class ConstantUtil {

	/**
	 * 
	 * 公共常量
	 *
	 */
	public static class Public {
		public static final String ID = "TESTID";
	}

	
	/**
	 * 
	 * 前缀
	 *
	 */
	public static class Prefix {
		public static final String MEMBER_ID = "MEMBER_";
	}
	
	/**
	 * JSP路径
	 */
	public static class JspFilePath {
		public static final String TESTCONTROLLER = "jsp/basic/";
		public static final String TEMPLATE_PAGEPATH = "basic/template/"; // 模板（测试）
	}

	/**
	 * vo 对象的一些公共的属性名称
	 *
	 */
	public static class VoFields {
		public static final String ACTIONTIME = "operateTime";// 操作时间
		public static final String ACTIONUSERNAME = "operatorName";// 操作人姓名
		public static final String CHECKTIME = "auditTime";// 审核时间
		public static final String CHECKUSERID = "checkUserId";// 审核人ID
		public static final String CHECKUSERNAME = "auditPerson";// 审核人姓名
		public static final String CREATETIME = "createTime"; // 创建时间
		public static final String CREATEUSERID = "createUserId";// 创建人code
		public static final String INSERTUSERNAME = "createUserName";// 创建人姓名
		public static final String UPDATETIME = "updateTime"; // 修改时间
		public static final String UPDATEUSERID = "updateUserId";// 修改人CODE
		public static final String UPDATEUSERNAME = "updateUserName";// 修改人姓名
		public static final String DELFLAG = "delFlag"; // 删除标记
		public static final String DBID = "dbid"; // 主键
	}

}
