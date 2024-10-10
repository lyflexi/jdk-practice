package org.lyflexi.debug_basicjdk.reflect.superclass;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.lyflexi.debug_basicjdk.exception.LyFlexiBusinessException;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: lyflexi
 * @project: jdk-practice
 * @Date: 2024/10/10 10:07
 */
@Slf4j
public class TestSuperClass {
    public static void main(String[] args) {
        TestSuperClass testSuperClass = new TestSuperClass();
        BodyEntity bodyEntity = new BodyEntity();
        String body = testSuperClass.buildBody(bodyEntity);
        log.info("body:{}",body);
        log.info("bodyEntity:{}", bodyEntity);

    }
    /**
     * 补充工厂编码，必传字段
     * @param paramObj
     * @return
     * @param <E>
     */
    private <E> String buildBody (E paramObj)  {

        String factoryCode = obtainInfo();
        Class<?> clazz = paramObj.getClass();

        Field field = null;

        // 检查父类是否有factoryCode字段
        for (Class<?> currentClass = clazz; currentClass != null; currentClass = currentClass.getSuperclass()) {
            try {
                field = currentClass.getDeclaredField("factoryCode");
                break; // 找到字段，跳出循环
            } catch (NoSuchFieldException e) {
                // 如果当前类没有这个字段，继续检查父类
                log.info("继续检查父类，当前类型为：{}",currentClass);
            }
        }

        if (field ==null){
            throw  LyFlexiBusinessException.exception("factoryCode字段丢失，类型为：{0}",clazz);
        }

        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        try {
            field.set(paramObj, factoryCode);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        String result = JSONObject.toJSONString(paramObj);
        return result;
    }

    /**
     * 获取工厂编码等补充信息
     * @return
     */
    private String obtainInfo() {
        return "X165";
    }
}
