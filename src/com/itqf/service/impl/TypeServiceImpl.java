package com.itqf.service.impl;

import com.itqf.dao.TypeDao;
import com.itqf.dao.impl.TypeDaoImpl;
import com.itqf.entity.Type;
import com.itqf.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    @Override
    public List<Type> findTypes() throws SQLException {

        TypeDao typedao = new TypeDaoImpl();

        List<Type> types = typedao.selectAll();

        return types;
    }
}
