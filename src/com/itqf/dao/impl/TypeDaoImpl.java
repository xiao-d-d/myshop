package com.itqf.dao.impl;

import com.itqf.dao.TypeDao;
import com.itqf.entity.Type;
import com.itqf.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public List<Type> selectAll() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        List<Type> types = queryRunner.query("select t_id as tid , t_name as tname , t_info as tinfo " +
                "from type limit 5",new BeanListHandler<Type>(Type.class));

        return types;
    }
}
