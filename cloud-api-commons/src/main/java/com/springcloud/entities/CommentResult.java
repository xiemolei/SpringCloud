package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : xiemogaminari
 * create at:  2020-05-23  16:18
 * @description: s
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommentResult(Integer code,String msg){
        this(code,msg,null);
    }
}