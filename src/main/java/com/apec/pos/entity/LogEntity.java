package com.apec.pos.entity;

import java.util.Date;

public class LogEntity<T> {
    private Integer id;
    private Date modifiedDate;
    private String modifiedBy;
    private T table;
}
