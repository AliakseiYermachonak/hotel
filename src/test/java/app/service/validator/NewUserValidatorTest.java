package app.service.validator;

import app.db.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NewUserValidatorTest {

    @Test
    public void checkingValidate() {
        assertTrue(new NewUserValidator().validate(new User("login", "paSSw0rd")));
    }
}
