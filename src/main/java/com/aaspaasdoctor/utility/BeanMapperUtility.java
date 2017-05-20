package com.aaspaasdoctor.utility;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component
public class BeanMapperUtility {

	
	
	public static void copyPropertiesIgnoreNull(Object source, Object dest) throws IllegalAccessException, InvocationTargetException {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        for(java.beans.PropertyDescriptor pd : pds) {
            if(!src.isReadableProperty(pd.getName()) || pd.getWriteMethod() == null){
                continue;
            }
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                continue;
            }
            
            org.apache.commons.beanutils.BeanUtils.copyProperty(dest, pd.getName(), srcValue);
        }
    }

}
