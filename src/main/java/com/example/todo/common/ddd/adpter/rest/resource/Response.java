package com.example.todo.common.ddd.adpter.rest.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Response<T> {
    private Integer code = 200;
    private String message = "操作成功";
    private T data;

    public Response(T data) {
        this.data = data;
    }
}
