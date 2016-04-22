package kr.ac.jejunu.userdao;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.sql.SQLException;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws Exception {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("김연주");
        user.setPassword("1111");

        long lastInsertedId = userDao.add(user);
        User user1 = userDao.get(lastInsertedId);

        MatcherAssert.assertThat(user1.getId(), Is.is(lastInsertedId));
        MatcherAssert.assertThat(user1.getName(), Is.is("김연주"));
        MatcherAssert.assertThat(user1.getPassword(), Is.is("1111"));


    }
}
