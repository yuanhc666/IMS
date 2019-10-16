package com.zhdtedu.util;

public class EnumUtil {
    /** 通过code获取枚举*/
    public static <T extends CodeEnum> T getEnumByCode(String code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return  each;
            }
        }
        return null;
    }

}
