package asu.jdbc.dao;

import asu.jdbc.DbUtil;
import asu.jdbc.model.Website;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebsiteDao {
    //  增加
    public List<Integer> addWebsite(Website website) throws SQLException {
        List<Integer> result = new ArrayList<Integer>();
        // 获取连接
        Connection conn = DbUtil.getConnection();
        // sql
        String sql = "INSERT INTO websites(name, url, alexa, country)"
                + "values(" + "?,?,?,?)";
        // 预编译
        PreparedStatement ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 预编译SQL，减少sql执行

        // 传参
        ptmt.setString(1, website.getName());
        ptmt.setString(2, website.getUrl());
        ptmt.setInt(3, website.getAlexa());
        ptmt.setString(4, website.getCountry());

        // 执行
         ptmt.execute(); // ptmt.executeUpdate();
        // https://blog.csdn.net/shootyou/article/details/6023428
        // You need to specify Statement.RETURN_GENERATED_KEYS to Statement.executeUpdate(), Statement.executeLargeUpdate() or Connection.prepareStatement()
        // ps = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // rs = ps.getGeneratedKeys();
        ResultSet rs = ptmt.getGeneratedKeys();
        if (rs != null && rs.next()) {
            result.add(rs.getInt(1));
            System.out.println(rs.getInt(1)); // 返回主键值
            // System.out.println("website id: " + website.getId()); // 此处无法取得返回值
        }

        return result;
    }

    public void updateWebsite(Website website) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql, 每行加空格
        String sql = "UPDATE websites" +
                " set name=?, url=?, alexa=?, country=?" +
                " where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        // 传参
        ptmt.setString(1, website.getName());
        ptmt.setString(2, website.getUrl());
        ptmt.setInt(3, website.getAlexa());
        ptmt.setString(4, website.getCountry());
        ptmt.setInt(5, website.getId());

        // 执行
        ptmt.execute();
    }

    public void delWebsite(int id) throws SQLException {
        //获取连接
        Connection conn = DbUtil.getConnection();
        //sql, 每行加空格
        String sql = "delete from websites where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        // 传参
        ptmt.setInt(1, id);

        // 执行
        ptmt.execute();
    }

    public List<Website> query() throws SQLException {
        Connection conn = DbUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, alexa, url FROM websites");

        List<Website> websites = new ArrayList<Website>();
        Website site = null;
        while (rs.next()) {
            site = new Website();
            site.setName(rs.getString("name"));
            site.setAlexa(rs.getInt("alexa"));
            site.setUrl(rs.getString("url"));

            websites.add(site);
        }
        return websites;
    }

    public Website get(int id) throws SQLException {
        Website website = null;
        // 获取连接
        Connection conn = DbUtil.getConnection();
        // sql, 每行加空格
        String sql = "select * from  websites where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setInt(1, id);
        //执行
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            website = new Website();
            website.setId(rs.getInt("id"));
            website.setName(rs.getString("name"));
            website.setAlexa(rs.getInt("alexa"));
            website.setUrl(rs.getString("url"));
            website.setCountry(rs.getString("country"));
        }
        return website;
    }
}
