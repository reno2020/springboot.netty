package com.reno.springboot.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jhl
 * @title: TestInfoResp
 * @projectName
 * @description: 业务响应类
 * @date 2021-1-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestInfoResp {
    private String message;
    private String reqContent;
}
