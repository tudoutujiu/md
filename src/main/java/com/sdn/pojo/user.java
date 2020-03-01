package com.sdn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class user {
    private Integer id;

    private String name;

    private String password;

    private String roleids;

    private String salt;

    public String getCredentialsSalt(){
        return name+salt;
    }

}