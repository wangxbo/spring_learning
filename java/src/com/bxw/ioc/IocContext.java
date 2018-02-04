package com.bxw.ioc;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IOC容器实现类
 *
 * 1、扫描加载指定包路径下的所有Class,并判断Class是否是@Component注解的类，如果是创建实例，
 * 保存至applicationContext缓存中。
 * 2、调用IocUtil.inject()，进行依赖注入。
 *
 * Created by wxb on 2018/2/4.
 */
public class IocContext {
    public static final Map<Class<?>, Object> applicationContext = new ConcurrentHashMap<>();
    static {
        String packageName = "com.bxw";
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void initBean(String packageName) throws Exception{
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
                .getResources(packageName.replaceAll("\\.", "/"));
        while (urls.hasMoreElements()){
            addClassByAnnotation(urls.nextElement().getPath(), packageName);
        }
        IocUtil.inject();

    }

    //获取指定包路径下实现 Component主键Bean的实例
    private  static void addClassByAnnotation(String filePath, String packageName){
        try {
            File[] files = getClassFile(filePath);
            if(files != null){
                for(File f : files){
                    String fileName = f.getName();
                    if(f.isFile()){
                        //判断该类是否实现了注解
                        Class<?> clazz = Class.forName(packageName + "." +
                        fileName.substring(0, fileName.lastIndexOf(".")));
                        if(clazz.isAnnotationPresent(Component.class)){
                            applicationContext.put(clazz, clazz.newInstance());
                        }
                    }else {
                        addClassByAnnotation(f.getPath(), packageName + "." + fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取该路径下所有的class文件和目录
    private static File[] getClassFile(String filePath){
        return new File(filePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
            }
        });
    }




}
