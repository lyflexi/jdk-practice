package org.lyflexi.debug_basicjdk.reflect.superclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Author: lyflexi
 * @project: jdk-practice
 * @Date: 2024/10/10 10:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BodyEntity extends BaseEntity{
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())
                +"@" + super.getFactoryCode();
    }

}
