package com.example.todo.common.ddd.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserException extends RuntimeException {
    private Integer code;

    public UserException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
