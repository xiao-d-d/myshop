package com.itqf.dao;

import com.itqf.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<Address> selectAddressByUid(int uid) throws SQLException;

    void insertAddress(Address address) throws SQLException;

    void deleteAddressByAid(String aid) throws SQLException;

    void updateAddressToDefault(String aid) throws SQLException;

    void updateAddressToCommons(String aid, int uid) throws SQLException;

    void updateAddressByAid(Address address) throws SQLException;
}
