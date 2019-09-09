package com.springboot.springboot.chapter5.typehandler;

import com.springboot.springboot.chapter5.enumration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 21:53
 * @Version 1.0
 */
//声明JdbcType为整型
@MappedJdbcTypes(JdbcType.INTEGER)
//声明JavaType类型为SexEnum
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    //设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    //通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        if(sex != 1 && sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    //根据下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        if(sex != 1 && sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if(sex != 1 && sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
}
