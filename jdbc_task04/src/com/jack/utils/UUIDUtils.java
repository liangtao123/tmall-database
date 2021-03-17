package com.jack.utils;

import java.util.UUID;

public class UUIDUtils {

    //获取唯一id的方法
    public static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "");
    }
}
