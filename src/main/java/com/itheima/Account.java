package com.itheima;

import java.io.Serializable;
import lombok.Data;

/**
 * account
 * @author 
 */
@Data
public class Account implements Serializable {
    private Integer id;

    private String name;

    private Double money;

    private static final long serialVersionUID = 1L;
}