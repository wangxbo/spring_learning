package com.bxw.ioc;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * IOC 注入实现
 *
 * 循环变量applicationContext中所有的bean，判断每个bean中是否有被@Inject注解修饰的属性，
 * 如果有则从applicationContext获取要注入的实例，并使用反射实现自动注入功能。
 *
 * Created by wxb on 2018/2/4.
 */
public class IocUtil {
    public static void inject(){
        Map<Class<?>, Object> map = IocContext.applicationContext;
        try {
            for(Map.Entry<Class<?>, Object> entry : map.entrySet()){
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                Field[] fields = clazz.getDeclaredFields();
                for(Field field : fields){
                    if(field.isAnnotationPresent(Inject.class)){
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = map.get(fieldClazz);
                        field.set(obj, fieldObj);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
