package com.demo.mavendemo.mapper;

import org.apache.ibatis.annotations.Select;

import com.demo.mavendemo.domain.Address;

public interface AddressRepository {

	@Select("SELECT * FROM `address` WHERE id = #{id}")
	Address findAddressById(Long id);

}
