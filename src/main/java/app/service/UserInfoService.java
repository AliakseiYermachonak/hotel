package app.service;

import app.db.dao.DaoDocType;
import app.db.dao.DaoUserInfo;
import app.db.entity.DocType;
import app.db.entity.UserInfo;
import app.db.entity.united.UUserInfo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class helps user to watch or add
 * user's additional information.
 * @author Alexey Yermachyonok
 * @version 1.0
 */
public class UserInfoService {

    private static final Logger LOGGER = Logger.getLogger(UserInfoService.class);

    private String messedge = "";
    private List<UserInfo> userInfos = null;
    private List<DocType> docTypes = null;
    private List<UUserInfo> uUserInfos = null;

    public UserInfoService(int id) {
        userInfos = new DaoUserInfo().getAll(id);
        docTypes = new DaoDocType().getAll();
        uUserInfos = new ArrayList<>();
    }

    /**
     * Method takes user info of a certain User.
     * @return List of new united infos
     */
    public List<UUserInfo> getUserInfos() {
        for (UserInfo userInfo : userInfos) {
            String document = "";
                for (DocType docType: docTypes) {
                    if (userInfo.getDocumentType() == docType.getIdDocType()) {
                        document = docType.getDocument();
                        break;
                    }
                }
                uUserInfos.add(new UUserInfo(userInfo, document));
        }
        return uUserInfos;
    }

}
