package springbook.user.test;

import springbook.user.dao.UserDao2;
import springbook.user.dao.chap03_1.DeleteDao;
import springbook.user.dao.chap03_1.UserDao3;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDao3Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DeleteDao dDao = new DeleteDao();
        dDao.deleteAll();

        UserDao3 dao = new UserDao3();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }


}
