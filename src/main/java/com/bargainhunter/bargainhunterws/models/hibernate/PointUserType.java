package com.bargainhunter.bargainhunterws.models.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class PointUserType implements UserType {
    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        assert strings.length == 1;
        if (resultSet.wasNull()) {
            return null;
        }

        Scanner scanner = new Scanner(resultSet.getObject(strings[0]).toString());
        scanner.findInLine("^\\((\\d+\\.\\d+),(\\d+\\.\\d+)\\)$");
        MatchResult result = scanner.match();

        double x = Double.parseDouble(result.group(1));
        double y = Double.parseDouble(result.group(2));

        return new org.springframework.data.geo.Point(x, y);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        preparedStatement.setObject(i, o);
    }

    @Override
    public int[] sqlTypes() {
        return new int[]
                {
                        Types.VARCHAR
                };
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return org.springframework.data.geo.Point.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        boolean isEqual = false;
        if (o == o1) {
            isEqual = true;
        }
        if (o == null || o1 == null) {
            isEqual = false;
        } else {
            isEqual = o.equals(o1);
        }
        return isEqual;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable srlzbl, Object o) throws HibernateException {
        return srlzbl;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return this;
    }

}