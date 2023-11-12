package com.just.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserInfo {
    private Integer id;
    private Integer userId;
    private String name;
    private String age;
    private String phone;
    private Boolean sex;
    private String email;
    private Long born;
    private String address;
}
