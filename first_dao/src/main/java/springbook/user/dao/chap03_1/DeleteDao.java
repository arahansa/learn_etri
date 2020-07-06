package springbook.user.dao.chap03_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
    private SimpleConnectionMaker simpleConnectionMaker;
    public DeleteDao() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    public void deleteAll()  throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("delete from users;");
        ps.executeUpdate();

        ps.close();
        c.close();

    }
}
