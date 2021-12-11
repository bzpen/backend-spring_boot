package com.example.demo.common.util;

import java.util.Random;

/**
 * 验证码生成
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class EmailCodeUtil {

    /**
     * 验证码位数
     */
    private final static Integer CODE_LENGTH = 6;

    /**
     * 生成验证码
     * @return
     */
    public static String creatCode(){
        Random random = new Random();
        StringBuffer code =new StringBuffer();
        for(int i = 0;i < CODE_LENGTH ;i ++){
            int ran1 = random.nextInt(10);
            code.append(String.valueOf(ran1));
        }
        return code.toString();
    }
}
