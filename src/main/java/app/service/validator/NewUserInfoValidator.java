package app.service.validator;

import app.db.entity.UserInfo;
import org.apache.log4j.Logger;

/**
 * Class for validating the parameteres of the user.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class NewUserInfoValidator implements Validator<UserInfo> {

    private static final Logger LOGGER = Logger.getLogger(NewUserInfoValidator.class);

    @Override
    public boolean validate(UserInfo userInfo) {

        if ((userInfo.getDocumentNumber() == null)
                || (userInfo.getDocumentType()  == 0)
                || (userInfo.getName() == null)
                || (userInfo.getSurname() == null)) {
            return false;
        }

        return ((userInfo.getDocumentNumber().matches("^[a-zA-Z0-9][a-zA-Zа-яА-Я0-9-_\\.]{1,30}$"))
                && ((userInfo.getName().isEmpty())||(userInfo.getSurname().isEmpty()))
                && ((userInfo.getDocumentType() > 0)&&(userInfo.getDocumentType() < 6)));
    }

}
