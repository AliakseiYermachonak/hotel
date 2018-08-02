package app.service;

import app.db.dao.DaoUser;
import app.db.dao.DaoUserInfo;
import app.db.entity.User;
import app.db.entity.UserInfo;
import app.db.entity.united.UUserInfo;
import app.service.validator.NewUserInfoValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class for giving to or taking from the User abilities.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class AdminProcessUserService {

    private static final Logger LOGGER = Logger.getLogger(AdminProcessUserService.class);

    private String message;
    private int idUser;
    private DaoUser daoUser;
    private HttpServletRequest req;
    private User user;


    public AdminProcessUserService(HttpServletRequest req){
        this.req = req;
        init();
    }

    /**
     * Initializing parameters of the method.
     */
    private void init(){
        message = "";
        String s = req.getParameter("idUser");
        idUser = Integer.parseInt(req.getParameter("idUser"));
        daoUser = new DaoUser();
        user = daoUser.get(idUser);
    }

    /**
     * Makes User an administrator.
     */
    public void setAdmin() {
        user.setIdRole(3);
        daoUser.update(user);
    }

    /**
     * Makes User just a usual User.
     */
    public void setDefaultUser() {
        user.setIdRole(1);
        user.setIdDelStatus(1);
        daoUser.update(user);
    }

    /**
     * For banning User.
     */
    public void banUser(){
        user.setIdDelStatus(2);
        daoUser.update(user);
    }

    /**
     * For looking throught additional user's inforamtion.
     */
    public void userInfo(){
        List<UUserInfo> uUserInfos = new UserInfoService(idUser).getUserInfos();
        req.setAttribute("uUserInfos", uUserInfos);
    }

    /**
     * For adding additional user's inforamtion.
     */
    public void addUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setDocumentNumber(req.getParameter("docNumber"));
        userInfo.setDocumentType((Integer.parseInt(req.getParameter("docType"))));
        userInfo.setIdUser((Integer.parseInt(req.getParameter("idUser"))));
        userInfo.setName(req.getParameter("name"));
        userInfo.setSurname(req.getParameter("surname"));
        userInfo.setPhoneNumber(req.getParameter("phoneNumber"));
        userInfo.setEmail(req.getParameter("email"));

        if (new NewUserInfoValidator().validate(userInfo)){
            new DaoUserInfo().insert(userInfo);
        }

    }
}
