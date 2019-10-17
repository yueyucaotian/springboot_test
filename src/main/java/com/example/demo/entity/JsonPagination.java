package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/17 17:45
 */
@Builder
@Data
public class JsonPagination {

    private String code;

    private long count;

    private Object data;

}
