package app.service.validator;

import app.db.entity.User;
import org.apache.log4j.Logger;

/**
 * Class for validating the parameteres of the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class NewUserValidator implements Validator<User> {

    private static final Logger LOGGER = Logger.getLogger(NewUserValidator.class);

    @Override
    public boolean validate(User user) {

        return (user.getLogin().matches("^[a-zA-Zа-яА-Я][a-zA-Zа-яА-Я0-9-_\\.]{1,20}$") &&
                user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"));
    }

}
