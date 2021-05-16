package com.bjpowernode.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getId(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
