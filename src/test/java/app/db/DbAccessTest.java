package app.db;

import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;

public class DbAccessTest {

    @Test
    public void checkintQuery(){
        ResultSet rs = new DbAccess().query("SELECT * FROM user");
        assertNotNull(rs);
    }

}
