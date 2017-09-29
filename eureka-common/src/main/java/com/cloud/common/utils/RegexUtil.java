package com.cloud.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配工具
 */
public class RegexUtil {
	
	/** 匹配手机号正则表达式 */
	public static final String REGEX_CELLPHONE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
	
	/** 匹配固话正则表达式 */
	public static final String REGEX_TELEPHONE = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
	
	/** 匹配特殊字符（非数字或英文字符）正则表达式 */
	public static final String REGEX_SPECIAL = "[^0-9A-Za-z]+";
	
	/** 匹配中文正则表达式 */
	public static final String REGEX_CHINESE = "[\u4e00-\u9fa5]";
	
	/** 空格 */
	public static final String REGEX_SPACE = "\\s";
	
	/** 邮箱 */
	public static final String REGEX_MAIL = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$";
	
	/**
	 * 验证手机号码
	 * 
	 * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
	 * 联通号码段:130、131、132、136、185、186、145
	 * 电信号码段:133、153、180、189
	 * 
	 * @param cellphone
	 * @return
	 */
	public static boolean isCellphone(String cellphone) {
		return checkIs(cellphone, REGEX_CELLPHONE);
	}
	 
	/**
	 * 验证固话号码
	 * 
	 * @param telephone
	 * @return
	 */
	public static boolean isTelephone(String telephone) {
		return checkIs(telephone, REGEX_TELEPHONE);
	}
	
	/**
	 * 验证字符串是否包含中文
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String param) {
        return checkExists(param, REGEX_CHINESE);
    }
	
	/**
	 * 验证邮箱
	 * @param str
	 * @return
	 */
	public static boolean isMail(String param) {
        return checkIs(param, REGEX_MAIL);
    }
	
	private static boolean checkIs(String param, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(param);
		return matcher.matches();
	}
	
	private static boolean checkExists(String param, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(param);
		return matcher.find();
	}
	
	public static void main(String[] args) {
//		System.out.println(checkCellphone("15262425245"));
//		System.out.println(checkCellphone("152624252"));
//		System.out.println(checkTelephone("052-38343222-2"));
//		System.out.println(checkTelephone("15262425245"));
		
//		System.out.println("a:::b-c:".replaceAll(REGEX_SPECIAL, ""));
		System.out.println(isContainChinese("你好"));
		System.out.println(isContainChinese("111"));
		System.out.println(isMail("811@com"));
	}
}
