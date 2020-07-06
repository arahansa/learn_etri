package springbook.user.test;

import springbook.user.dao.chap03_1.DeleteDao;
import springbook.user.dao.chap03_1.UserDao3;
import springbook.user.dao.chap03_2_inter.DConnectionMaker;
import springbook.user.dao.chap03_2_inter.UserDao4;
import springbook.user.dao.chap03_3_seper.UserDao5;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDao5Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DeleteDao dDao = new DeleteDao();
        dDao.deleteAll();

        UserDao5 dao = new UserDao5(new DConnectionMaker());

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
