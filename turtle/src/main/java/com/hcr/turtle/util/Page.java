package com.hcr.turtle.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页实体类
 */
@Getter
@Setter
@ToString
public class Page {
    private Object object;
    private Integer total;


    public Page() {
    }

    public Page(Object object, Integer total) {
        this.object = object;
        this.total = total;
    }
}
