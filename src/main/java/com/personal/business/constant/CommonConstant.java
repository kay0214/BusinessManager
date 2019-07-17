package com.personal.business.constant;

/**
 * 通用常量
 *
 * @author framework
 */
public interface CommonConstant {

    /**
     * 用户名最小长度
     * */
    Integer USERNAME_MIN_LENGTH = 5;

    /**
     * 用户名最大长度
     * */
    Integer USERNAME_MAX_LENGTH = 20;

	/**
	 *  菜单类型 [M:目录; C:菜单; F:按钮功能]
	 */
	String MENU_TYPE_M = "M";

	String MENU_TYPE_C = "C";

	String MENU_TYPE_F = "F";

    /**
     * 数据源控制优先级别(值越小优先级越高)，读方法切面
     */
    String[] DATASOURCE_QUERY_PREFIX = {"select","query","count","search","get","find","check","export"};
    int DATASOURCE_AOP_DS = 1;
    int DATASOURCE_AOP_TRANSACTION = 2;
    /**
     * 手机号码格式限制 - 11位数字，以1开头
     */
    String MOBILE_PHONE_NUMBER_PATTERN = "^1\\d{10}$";

    /**
     * 邮箱格式限制
     */
    String EMAIL_PATTERN = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?";

}
