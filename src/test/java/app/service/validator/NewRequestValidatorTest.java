package app.service.validator;

import app.db.entity.Request;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class NewRequestValidatorTest {

    @Test
    public void checkingValidate(){
        int idUser = 1;
        int days = 1;
        int idRoomType = 1;
        int rooms = 1;
        int idRequestStatus = 1;
        assertTrue(new NewRequestValidator().validate(new Request(idUser, new Date(), days, idRoomType, rooms, idRequestStatus)));
    }
}
