package com.yl.pmt.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @author pch
 * @version v1.0
 * @title EntityConvertUtil
 * @description 实体转换工具
 * @date 2021/5/27 3:45 下午
 */
@Slf4j
public final class EntityConvertUtil {
	/**
	 * 实体类转换， sourceObj的属性 如果在 targetObj存在， 则覆盖掉targetObj的属性
	 *
	 * @param sourceObj   源对象
	 * @param convertType 需要转对象的类型
	 * @return 覆盖后的对象
	 */
	public static Object convert(Object sourceObj, String convertType) {
		Object targetObj = getMappingObj(sourceObj.getClass(), convertType);
		BeanUtils.copyProperties(sourceObj, targetObj);
		return targetObj;
	}

	/**
	 * 通过目标Class，反射实例化 进行实体类属性赋值转换
	 *
	 * @param sourceObj   源对象
	 * @param targetClass 目标CLass
	 * @return
	 */
	public static Object convertByClass(Object sourceObj, Class targetClass) {
		try {
			Object o = targetClass.newInstance();
			BeanUtils.copyProperties(sourceObj, o);
			return o;
		} catch (InstantiationException | IllegalAccessException e) {
			log.error("error:", e);
		}
		return null;
	}


	/**
	 * 映射实体类属性值
	 * 取源对象class 获取类名，取type为要映射成为的类名。
	 * 例如 参数1: UserDetailVo.class     参数2: Po
	 * 先查找对象为  User , 再匹配为 dto.UserDetailPo
	 * 要求 类名Po Vo 必须大写， 并且包名为 vo.xxxVo  dto.xxxPo
	 *
	 * @param clz  源对象class
	 * @param type Po or Vo
	 * @return 返回 Vo或Po对象
	 */
	private static Object getMappingObj(Class clz, String type) {
		Object object = new Object();
		String targetClassName = "";
		String sourceClassName = clz.getName();

		if (sourceClassName.endsWith("Po")) {
			targetClassName = getTargetClassName(sourceClassName, "Po", type);
		} else if (sourceClassName.endsWith("Vo")) {
			targetClassName = getTargetClassName(sourceClassName, "Vo", type);
		} else if (sourceClassName.endsWith("Dto")) {
			targetClassName = getTargetClassName(sourceClassName, "Dto", type);
		}
		try {
			Class<?> targetClass = Class.forName(targetClassName);
			object = targetClass.newInstance();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("实体类转换时 未发现 " + targetClassName + " 类，请确认实体类是否存在");
		} catch (IllegalAccessException | InstantiationException e) {
			log.error("error:", e);
		}
		return object;
	}

	/**
	 * 获取目标类的class类名
	 *
	 * @param sourceClassName 源类名
	 * @param sourceType      源类型    Vo or Po
	 * @param targetType      目标类型  Po or Vo
	 * @return xxxVo对象或者 xxxPo对象
	 */
	private static String getTargetClassName(String sourceClassName, String sourceType, String targetType) {
		sourceClassName = sourceClassName.replace("." + sourceType.toLowerCase(), "." + targetType.toLowerCase());
		return sourceClassName.substring(0, sourceClassName.length() - sourceType.length()) + targetType;
	}

	public static void main(String[] args) {
		String sourceClassName = "com.yl.domain.dto.ClothesPostPo";
		String sourceType = "Po";
		String targetType = "Vo";
		String targetClassName = getTargetClassName(sourceClassName, sourceType, targetType);
		System.out.println(targetClassName);
	}
}
