package springbook.user.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.springway.AppConfig;
import springbook.springway.UserDaoSpring;
import springbook.user.domain.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDaoSpringTest {

    @Test
    public void testDeleteAll() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDaoSpring userDao = applicationContext.getBean("userDao", UserDaoSpring.class);

        userDao.deleteAll();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");


        userDao.add(user);

        User whiteship = userDao.get("whiteship");
        assertNotNull(whiteship);
        assertEquals(whiteship.getName(), "백기선");
        assertEquals(whiteship.getPassword(), "married");
    }
}
