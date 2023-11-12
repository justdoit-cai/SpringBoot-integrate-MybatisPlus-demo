package com.just.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationLog {
    private Integer id;
    private String tableName;
    private String operation;
    private Long operationTime;
    private String operationParams;
}
