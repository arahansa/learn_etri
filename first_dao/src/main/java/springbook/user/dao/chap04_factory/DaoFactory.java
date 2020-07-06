package springbook.user.dao.chap04_factory;

import springbook.user.dao.chap03_2_inter.DConnectionMaker;
import springbook.user.dao.chap03_3_seper.UserDao5;

public class DaoFactory {

    public UserDao5 userDao(){
        UserDao5 dao = new UserDao5(new DConnectionMaker());
        return dao;
    }

}
