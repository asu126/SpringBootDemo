package cn.mybatis.mydemo3.mapper;

import cn.mybatis.mydemo3.domain.User;

public interface UserMapper {
    User selectUserById(int id);
}
