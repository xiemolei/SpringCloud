package com.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entities.CommentResult;

/**
 * @author : xiemogaminari
 * create at:  2020-07-08  16:55
 * @description:
 */
public class CustomerBlockHandler {
    public static CommentResult handlerException(BlockException exception)
    {
        return new CommentResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommentResult handlerException2(BlockException exception)
    {
        return new CommentResult(4444,"按客戶自定义,global handlerException----2");
    }
}