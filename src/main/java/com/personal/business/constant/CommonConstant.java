package com.personal.business.constant;

/**
 * 通用常量
 *
 * @author framework
 */
public interface CommonConstant {

    /**
     * 出库
     */
    Integer OUT_WAREHOUSE = 1;

    /**
     * 入库
     */
    Integer IN_WAREHOUSE = 2;

    /**
     * 公司 - 默认本部
     */
    String COMPANY_CENTRAL_DEPARTMENT = "本部";

    /**
     * 数据字典 - 状态
     */
    String DICTIONARY_STATUS_FORBIDDEN = "2";

    /**
     * 数据字典 - 状态
     */
    String DICTIONARY_STATUS = "status";

    /**
     * 数据字典 - 待分类
     */
    String DICTIONARY_RELATIONSHIP_UNKNOWN = "8";

    /**
     * 数据字典 - 人员
     */
    String DICTIONARY_RELATIONSHIP_STAFF = "7";

    /**
     * 数据字典 - 往来公司/个人
     */
    String DICTIONARY_RELATIONSHIP = "relationship";

    /**
     * 已用
     */
    Integer USED = 1;

    /**
     * 未用
     */
    Integer NOT_USE = 0;

    /**
     * 数据字典 - 内置
     */
    Integer DICTIONARY_BUILD_IN = 1;

    /**
     * 数据字典 - 不内置
     */
    Integer DICTIONARY_NOT_BUILD_IN = 0;

    /**
     * 数据字典 - 全部
     */
    String DICTIONARY_ALL = "all";

    /**
     * thymeleaf配置 - 权限模板工具
     */
    String THYMELEAF_TEMPLATE_UTILS = "permission";

    /**
     * session中缓存权限的key
     */
    String SESSION_KEY_PERMISSIONS = "permissions";

    /**
     * 菜单URL - 默认
     */
    String MENU_INSERT_DEFAULT_VALUE = "#";

    /**
     * 用户类型 - 系统用户
     */
    String USER_TYPE_SYSTEM = "00";

    /**
     * 验证码key
     */
    String CURRENT_CAPTCHA = "captcha";

    /**
     * 验证码错误
     */
    String CAPTCHA_ERROR = "captchaError";

    /**
     * 验证码
     */
    String CURRENT_VALIDATECODE = "validateCode";

    /**
     * 验证码开关
     */
    String CURRENT_ENABLED = "captchaEnabled";

    /**
     * 验证码类型：math
     */
    String CAPTCHA_TYPE_MATH = "math";

    /**
     * 验证码类型：char
     */
    String CAPTCHA_TYPE_CHAR = "char";

    /**
     * 用户名最小长度
     * */
    Integer USERNAME_MIN_LENGTH = 5;

    /**
     * 用户名最大长度
     * */
    Integer USERNAME_MAX_LENGTH = 20;

    Integer DEL_FLAG_EXIST= 0;

    Integer DEL_FLAG_NOT_EXIST = 1;

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
