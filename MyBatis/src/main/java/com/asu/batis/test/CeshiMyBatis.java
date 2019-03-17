import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.asu.batis.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 维C果糖 on 2017/4/2.
 */
public class CeshiMyBatis {
    @Test
    public void testQuery() throws IOException {   // 查询记录
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         */
        String resource = "mybatis-config.xml";           // 定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession

        Person findPerson = new Person();
        findPerson.setAge(18);

        // 调用 mapper 中的方法：命名空间 + id
        List<Person> personList = sqlSession.selectList("com.asu.batis.UserMapper.findAll", findPerson);

        for (Person p : personList) {
            System.out.println(p);
        }
    }

    @Test
    public void testInsert() throws IOException {
        String resource = "mybatis-config.xml";           //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            //获取到 SqlSession

        Person p = new Person();
        p.setId(5);
        p.setName("gavin");
        p.setAge(12);

        sqlSession.insert("com.asu.batis.UserMapper.insert", p);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    @Test
    public void testUpdate() throws IOException {   // 修改方法
        String resource = "mybatis-config.xml";            //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        Person p = new Person();
        p.setId(1);
        p.setAge(12);

        sqlSession.insert("com.asu.batis.UserMapper.update", p);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    @Test
    public void testDeleteById() throws IOException {
        String resource = "mybatis-config.xml";           //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        sqlSession.delete("com.asu.batis.UserMapper.deleteById", 2);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    @Test
    public void testDeleteArray() throws IOException {   // 批量删除
        String resource = "mybatis-config.xml";            //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        sqlSession.delete("com.asu.batis.UserMapper.deleteArray", new Integer[]{2, 3, 4});
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }

    /*@Test
    public void testDeleteList() {   // 批量删除
        String resource = "mybatis-config.xml";            //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        List<Integer> personList = new ArrayList<Integer>();

        personList.add(2);
        personList.add(3);
        personList.add(4);

        sqlSession.delete("com.asu.batis.UserMapper.deleteList", personList);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }*/

    /*@Test
    public void testDeleteMap() {   // 批量删除
        String resource = "mybatis-config.xml";            //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);        // 创建 SqlSessionFactory

        SqlSession sqlSession = sqlSessionFactory.openSession();            // 获取到 SqlSession

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("ids", new Integer[]{2, 3, 4});
        map.put("age",18);

        sqlSession.delete("com.asu.UserMapper.deleteMap", map);
        sqlSession.commit();            //默认是不自动提交，必须手工提交
    }*/
}