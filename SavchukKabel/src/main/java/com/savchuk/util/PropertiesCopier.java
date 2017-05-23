package com.savchuk.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class PropertiesCopier extends BeanUtils {
	
	private static final Log log = LogFactory.getLog(PropertiesCopier.class);
	
	/**
	 * Copy the property values of the given source bean into the given target
	 * bean if target bean properties is NULL or Empty, ignoring the given
	 * "ignoreProperties".
	 * <p>
	 * Note: The source and target classes do not have to match or even be
	 * derived from each other, as long as the properties match. Any bean
	 * properties that the source bean exposes but the target bean does not will
	 * silently be ignored.
	 * <p>
	 * This is just a convenience method. For more complex transfer needs,
	 * consider using a full BeanWrapper.
	 * 
	 * @param source
	 *            the source bean
	 * @param target
	 *            the target bean
	 * @param ignoreProperties
	 *            array of property names to ignore
	 * @throws BeansException
	 *             if the copying failed
	 * @see BeanWrapper
	 */
	public void copyNotNullProperties(Object source, Object target, String... ignoreProperties) {
		List<String> ignoredProp = new LinkedList<>(Arrays.asList(ignoreProperties));
		
		//add not null target properties they will be ignored
		List<String> notNullTargetProps = this.getNotNullProperties(target);
		//add null and empty source properties they will be ignored
		List<String> notNullSourceProps = this.getNullProperties(source);
		
		ignoredProp.addAll(notNullTargetProps);
		ignoredProp.addAll(notNullSourceProps);
		
		BeanUtils.copyProperties(source, target, ignoredProp.toArray(new String[0]));
	}
	
	private List<String> getNotNullProperties(Object obj) {
		List<String> notNullProp = new LinkedList<>();
		try {
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(obj) != null) {
					//If Object is Empty String dont add in not empty List
					if (f.get(obj) instanceof String) {
						String strVal = (String) f.get(obj);
						if (strVal.equals(""))
							continue;
					}
					
					notNullProp.add(f.getName());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		
		return notNullProp;
	}
	
	private List<String> getNullProperties(Object obj) {
		List<String> nullProp = new LinkedList<>();
		try {
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(obj) == null) {
					nullProp.add(f.getName());
					continue;
				}
				if (f.get(obj) instanceof String) {
					String strVal = (String) f.get(obj);
					if (strVal.equals(""))
						nullProp.add(f.getName());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		
		return nullProp;
	}
	
}
