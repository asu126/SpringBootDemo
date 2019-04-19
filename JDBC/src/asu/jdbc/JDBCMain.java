package asu.jdbc;

import asu.jdbc.dao.WebsiteDao;
import asu.jdbc.model.Website;

import java.util.List;

public class JDBCMain {

    public static void main(String[] args) throws Exception {
        WebsiteDao dao = new WebsiteDao();

        // select
        System.out.println(dao.get(1));
        System.out.println(dao.query());

        // insert
        Website web = new Website("test", "https://www.test.com/", 33,"china");
        List<Integer> ins = dao.addWebsite(web);

        // update
        web.setUrl("https://www.test.com/new");
        web.setId(13);
        dao.updateWebsite(web);

        // delete
        for(Integer i: ins){
            dao.delWebsite(i);
        }

        dao.transferAccounts();
    }

}
