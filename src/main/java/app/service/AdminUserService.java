package app.service;

import app.db.dao.DaoDelStatus;
import app.db.dao.DaoRole;
import app.db.dao.DaoUser;
import app.db.dao.DaoUserInfo;
import app.db.entity.DelStatus;
import app.db.entity.Role;
import app.db.entity.User;
import app.db.entity.UserInfo;
import app.db.entity.united.UUser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps to get the List of Users from Database
 * and to transmit it to client.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class AdminUserService {
    private static final Logger LOGGER = Logger.getLogger(AdminUserService.class);
    List<User> users;
    List<Role> roles;
    List<DelStatus> delStatuses;
    List<UserInfo> usersInfos;
    List<UUser> uUsers;
    String userRole;
    String userDelStatus;

    public AdminUserService(){
        delStatuses = new DaoDelStatus().getAll();
        roles = new DaoRole().getAll();
        users = new DaoUser().getAll();
        usersInfos = new DaoUserInfo().getAll();
        uUsers = new ArrayList<>();
        userRole = "";
        userDelStatus = "";
    }

    /**
     * Method takes the Users from Databases and combines.
     * @return List of united Users
     */
    public List<UUser> getUUsers() {
        for(User user: users){
            for(Role role: roles) {
                if (role.getIdRole() == user.getIdRole()){
                    userRole = role.getRole();
                }
            }
            for(DelStatus delStatus: delStatuses) {
                if (delStatus.getIdDelStatus() == user.getIdDelStatus()){
                    userDelStatus = delStatus.getStatus();
                }
            }
            uUsers.add(new UUser(user, userRole, userDelStatus));
        }
        return uUsers;
    }
}
