package com.example.demo.common.web.domain;

/**
 * 统一响应 Controller
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
public class ResultController {

    /**
     * 成功操作
     */
    public Result success(){
        return Result.success();
    }

    /**
     * 成功操作
     */
    public Result success(String msg){
        return Result.success(msg);
    }

    /**
     * 成功操作
     */
    public Result success(Object data){
        return Result.success(data);
    }

    /**
     * 成功操作
     */
    public Result success(String msg, Object data){
        return Result.success(msg,data);
    }

    /**
     * 成功操作
     */
    public Result success(int code, String message, Object data){
        return Result.success(code,message,data);
    }

    /**
     * 失败操作
     */
    public Result failure(){
        return Result.failure();
    }

    /**
     * 失败操作
     */
    public Result failure(String msg){
        return Result.failure(msg);
    }

    /**
     * 失败操作
     */
    public Result failure(int code, String msg){
        return Result.failure(code, msg);
    }

    /**
     * 失败操作
     */
    public Result failure(String msg, Object data){
        return Result.failure(msg,data);
    }

    /**
     * 失败操作
     */
    public Result failure(int code, String msg, Object data){
        return Result.failure(code,msg,data);
    }

    /**
     * 选择返回
     */
    public Result decide(Boolean b){
        return Result.decide(b);
    }

    /**
     * 选择返回
     */
    public Result decide(Boolean b, String success, String failure){
        return Result.decide(b,success,failure);
    }

    /**
     * 选择返回
     */
    public Result decide(int result){
        if(result>0){
            return Result.decide(true);
        }else{
            return Result.decide(false);
        }
    }

    /**
     * 选择返回
     */
    public Result decide(int result, String success, String failure){
        if(result>0){
            return Result.decide(true,success,failure);
        }else{
            return Result.decide(false,success,failure);
        }
    }

}
