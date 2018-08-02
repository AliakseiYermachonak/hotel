package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Role entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoRole implements DaoEntity<Role> {

    /**
     * Writing  a new Role Entity into the database
     * @param ob Role
     */
	@Override
	public void insert(Role ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO role VALUES (?,?)");
			ps.setInt(1, ob.getIdRole());
			ps.setString(2, ob.getRole());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Updating an existing Role Entity in the database
     * @param ob Role
     */
	@Override
	public void update(Role ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE role SET role = ? WHERE id_busy_role = ?");
			ps.setString(1, ob.getRole());
			ps.setInt(2, ob.getIdRole());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting an Role Entity from the database
     * @param ob Role
     */
	@Override
	public void delete(Role ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM role WHERE id_role = ?");
			ps.setInt(1, ob.getIdRole());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing Role Entity from the database
     * @param id int identifier
     * @return Role
     */
	@Override
	public Role get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM role WHERE id_role = " + id);
			if(rs.next()) {
				return new Role(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new Role();
	}

    /**
     * Reading all existing Entities from the database
     * @return List of Roles
     */
	@Override
	public List<Role> getAll() {
		ArrayList<Role> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM role");
			while(rs.next()) {
				list.add(new Role(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<Role>();
	}

}
