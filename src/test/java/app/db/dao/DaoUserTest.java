package app.db.dao;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DaoUserTest {

    @Test
    public void checkingGet(){
        assertNotNull(new DaoUser().get(1));
    }
}
