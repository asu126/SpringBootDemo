package cn.mybatis.mydemo2.mapper;

import cn.mybatis.mydemo2.domain.Clazz;

public interface ClazzMapper {
    // 根据id查询班级信息
    Clazz selectClazzById(Integer id);
}