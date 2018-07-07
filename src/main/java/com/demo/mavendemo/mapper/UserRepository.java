package com.demo.mavendemo.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import org.apache.ibatis.annotations.Many;

import com.demo.mavendemo.domain.User;

public interface UserRepository {

	@Select("SELECT * FROM `user` WHERE id=#{id}")
	// column:数据库中表的字段
	// property：数据库中表所有映射的实体类javaBean中的属性名
	// jdbcType
	@Results({ @Result(column = "address_id", property = "addressId") })
	User findUserById(Long id);

	/*
	 * 使用@Resutl注解对返回的结果进行配置， - property = “address”, 表示要将返回的查询结果赋值给user的address属性 -
	 * column = “address_id”
	 * 是指将user表中的address_id作为com.kingboy.repository.address.AddressRepository.
	 * findAddressById的查询参数 - one 表示这是一个一对一的查询 - @One(select = “方法全路径) 表示我们调用的方法
	 * 
	 */
	@Select("SELECT * FROM `user` WHERE id=#{id}")
	@Results({
			@Result(property = "address", column = "address_id", one = @One(select = "com.demo.mavendemo.mapper.AddressRepository.findAddressById")) })
	User findUserWithAddress(Long id);

	/*
	 * 使用@Resutl注解对返回的结果进行配置， - property = “cars”, 表示要将返回的查询结果赋值给user的cars属性 -
	 * column = “id” 是指将user表中的用户主键id作为com.kingboy.repository.address.CarRepository.
	 * findCarByUserId的查询参数 - many 表示这是一个一对多的查询 - @Many(select = “方法全路径) 表示我们调用的方法,
	 * 方法参数userId就是上面column指定的列值
	 *
	 */
	@Select("SELECT * FROM `user` WHERE id = #{id}")
	@Results({
			@Result(property = "cars", column = "id", many = @Many(select = "com.demo.mavendemo.mapper.CarRepository.findCarByUserId")) })
	User getUserWithCar(Long id);
}
