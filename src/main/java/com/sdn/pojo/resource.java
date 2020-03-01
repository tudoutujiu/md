package com.sdn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class resource {
    private Integer id;

    private Integer pid;

    private String title;

    private String href;

    private String mclass;

    private String permission;

}