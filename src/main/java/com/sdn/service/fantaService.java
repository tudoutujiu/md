package com.sdn.service;

import com.sdn.pojo.fanta;

import java.util.List;

public interface fantaService extends baseService<fanta> {
    List<fanta> getAll();
}
