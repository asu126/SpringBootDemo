package com.demo.mavendemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.demo.mavendemo.domain.Car;

public interface CarRepository {

	@Select("SELECT * FROM `car` WHERE user_id = #{userId}")
	List<Car> findCarByUserId(Long userId);

}
