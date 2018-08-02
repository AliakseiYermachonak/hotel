package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of User entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoUser implements DaoEntity<User> {

    /**
     * Writing a new User Entity into the database
     * @param ob User
     */
	@Override
	public void insert(User ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO user (login, password, id_role, id_del_status)" +
                    "VALUES (?,?,?,?)");

			ps.setString(1, ob.getLogin());
			ps.setString(2, ob.getPassword());
			ps.setInt(3, ob.getIdRole());
			ps.setInt(4, ob.getIdDelStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Writing a new User Entity into the database
     * @param login, password
     */
    public void insert(String login, String password) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO user (login, password) VALUE (?,?)");
            ps.setString(1, login);
            ps.setString(2, password);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
    }

    /**
     * Updating an existing User Entity in the database
     * @param ob User
     */
	@Override
	public void update(User ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE user SET login = ?, password = ?, id_role = ?, id_del_status = ? WHERE id_user = ?");
			ps.setString(1, ob.getLogin());
			ps.setString(2, ob.getPassword());
			ps.setInt(3, ob.getIdRole());
			ps.setInt(4, ob.getIdDelStatus());
			ps.setInt(5, ob.getIdUser());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Deleting an User Entity from the database
     * @param ob User
     */
	@Override
	public void delete(User ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE user SET id_del_status = 3 WHERE id_user = " + ob.getIdUser());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Reading existing User Entity from the database
     * @param id int identifier
     * @return User
     */
	@Override
	public User get(int id) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE id_user = " + id);
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new User();
	}

    /**
     * Reading all existing User Entities from the database
     * @param login String
     * @return User
     */
	public User get(String login) {
        Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE login = '" + login + "'");

			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new User();
	}

    /**
     * Reading all existing User Entities from the database
     * @return List of Users
     */
	@Override
	public List<User> getAll() {
		ArrayList<User> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user");

			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return list;
	}
}
