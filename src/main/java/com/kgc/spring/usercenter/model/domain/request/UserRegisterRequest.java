package com.kgc.spring.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 马昌瑞
 * @version 1.0
 */
@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = -7931563006795563129L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
