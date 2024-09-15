package org.lyflexi.debug_basicjdk.reflect.TInfo;

/**
 * @Description:
 * @Author: lyflexi
 * @project: jdk-practice
 * @Date: 2024/9/15 16:09
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    /**
     * 来自于jdk17：Class<T>类注释
     * Type parameters:
     * <T> – the type of the class modeled by this Class object.
     * For example, the type of String. class is Class<String>.
     * Use Class<?> if the class being modeled is unknown.
     *
     * @param clazz
     * @param <T>
     */
    public <T> void useClass(Class<T> clazz) {
        // 获取类名
        logger.info("Full name: {}", clazz.getName());
        logger.info("Simple name: {}", clazz.getSimpleName());

        // 获取直接超类
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            logger.info("Superclass: {}", superClass.getName());
        } else {
            logger.info("This is the top-level class.");
        }

        // 获取实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            logger.info("Implemented interfaces: {}", java.util.Arrays.toString(interfaces));
        }

        // 获取构造函数
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length > 0) {
            logger.info("Declared constructors: {}", java.util.Arrays.toString(constructors));
        }

        // 获取方法
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length > 0) {
            logger.info("Declared methods: {}", java.util.Arrays.toString(methods));
        }

        // 获取字段
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0) {
            logger.info("Declared fields: {}", java.util.Arrays.toString(fields));
        }

        // 获取注解
        if (clazz.isAnnotationPresent(Deprecated.class)) {
            logger.info("The class is marked as @Deprecated.");
        } else {
            logger.info("The class is not marked as @Deprecated.");
        }
    }

    public static void main(String[] args) {
        Example example = new Example();

        // 使用 Integer 类作为 T 的类型
        example.useClass(Integer.class);

        // 使用 String 类作为 T 的类型
        example.useClass(String.class);

        // 使用自定义类作为 T 的类型
        class CustomClass {
            public int x;
            public int y;

            public CustomClass(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void printXY() {
                logger.info("X: {}, Y: {}", x, y);
            }
        }

        example.useClass(CustomClass.class);
    }
}