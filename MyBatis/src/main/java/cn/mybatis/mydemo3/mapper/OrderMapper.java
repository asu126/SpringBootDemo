package cn.mybatis.mydemo3.mapper;

import cn.mybatis.mydemo3.domain.Order;

public interface OrderMapper {
    Order selectOrderById(int id);
}
