package com.ceshiren.Exception;

/**
 * @Author chenqiang
 * @create 2023/11/6 02:30
 */
public class NotExistException extends Exception {
    public NotExistException(){}
    public NotExistException(String message){
        super(message);
    }
}
