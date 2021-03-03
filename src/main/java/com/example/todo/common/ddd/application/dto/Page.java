package com.example.todo.common.ddd.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page <T>{
    private final List<T> results;
    private final int pageSize;
    private final int pageNum;
    private final long total;

    public Page(List<T> results, int pageSize, int pageNum, long total) {
        this.results = results;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
    }

}
