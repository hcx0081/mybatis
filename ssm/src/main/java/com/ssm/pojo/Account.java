package com.ssm.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @TableName account
 */
@Data
public class Account {
    private Integer id;
    private String name;
    private BigDecimal money;
}