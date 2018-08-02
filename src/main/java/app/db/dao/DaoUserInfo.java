package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of User Info entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoUserInfo implements DaoEntity<UserInfo> {

    /**
     * Writing a new UserInfo Entity into the database
     * @param ob UserInfo
     */
	@Override
	public void insert(UserInfo ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO user_info (document_number, document_type, id_user, name, surname, phone_number, email, orders_done)" +
					"VALUES (?,?,?,?,?,?,?,?)");

			ps.setString(1, ob.getDocumentNumber());
			ps.setInt(2, ob.getDocumentType());
			ps.setInt(3, ob.getIdUser());
			ps.setString(4, ob.getName());
			ps.setString(5, ob.getSurname());
			ps.setString(6, ob.getPhoneNumber());
			ps.setString(7, ob.getEmail());
			ps.setInt(8, ob.getOrdersDone());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Updating an existing UserInfo Entity in the database
     * @param ob UserInfo
     */
	@Override
	public void update(UserInfo ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO user_info VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, ob.getDocumentNumber());
			ps.setInt(2, ob.getDocumentType());
			ps.setInt(3, ob.getIdUser());
			ps.setString(4, ob.getName());
			ps.setString(5, ob.getSurname());
			ps.setString(6, ob.getPhoneNumber());
			ps.setString(7, ob.getEmail());
			ps.setInt(8, ob.getOrdersDone());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Deleting a UserInfo Entity from the database
     * @param ob UserInfo
     */
	@Override
	public void delete(UserInfo ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE user_info SET id_user= ?, name = ?, surname = ?, phone_number = ?, email = ?, orders_done = ? WHERE document_number = ? AND  document_type = ?");
			ps.setInt(1, ob.getIdUser());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getSurname());
			ps.setString(4, ob.getPhoneNumber());
			ps.setString(5, ob.getEmail());
			ps.setInt(6, ob.getOrdersDone());
			ps.setString(7, ob.getDocumentNumber());
			ps.setInt(8, ob.getDocumentType());
			
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Reading existing UserInfo Entity from the database
     * @param id int identifier
     * @return UserInfo
     */
	@Override
	public UserInfo get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM user_info WHERE document_number = " + id);
			if(rs.next()) {
				//return new UserInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new UserInfo();
	}

    /**
     * Reading existing UserInfo Entity from the database
     * @param docType int document type, document number
     * @return UserInfo
     */
	public UserInfo get(String docNumber, int docType) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM user_info WHERE document_number = " + docNumber + " AND document_type=" +  docType);
			if(rs.next()) {
				return new UserInfo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new UserInfo();
	}

    /**
     * Reading all existing UserInfo Entities from the database
     * @return List of UserInfos
     */
	@Override
	public List<UserInfo> getAll() {
		ArrayList<UserInfo> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM user_info");
			while(rs.next()) {
				list.add(new UserInfo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new ArrayList<UserInfo>();
	}

    /**
     * Reading all existing UserInfo Entities from the database
     * @param id int identifier
     * @return List of UserInfos
     */
    public List<UserInfo> getAll(int id) {
        ArrayList<UserInfo> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user_info WHERE id_user = " + id);
            while(rs.next()) {
                list.add(new UserInfo(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
        return new ArrayList<UserInfo>();
    }
}
