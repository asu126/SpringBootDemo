package cn.mybatis.domain;

import cn.mybatis.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class OneToOneTest {
    public static void main(String[] args) throws Exception {

        String resource = "mybatis-config.xml";           // 定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 初始化mybatis,创建SqlSessionFactory 类的实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建Session 实例
        SqlSession session = sqlSessionFactory.openSession();
        // 获得代理对象接口白mapper
        PersonMapper pm = session.getMapper(PersonMapper.class);
        // 直接调用接口的方法，查询id为1的Peson数据
        Person p = pm.selectPersonById(1);
        // 打印Peson对象
        System.out.println(p);
        // 打印Person对象关联的Card对象
        System.out.println(p.getCard());
        // 提交事务
        session.commit();
        // 关闭Session
        session.close();
    }
}
