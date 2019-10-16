package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/16 10:54
 */

@Builder
@Data
public class JsonResult {

    private String code;

    private String message;

    private Object data;
}
