package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.DelStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Del Status entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoDelStatus implements DaoEntity<DelStatus> {

	/**
	 * Writing  a new Del Status Entity into the database
     * @param ob Del Status
	 */
	@Override
	public void insert(DelStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO del_status VALUES (?,?)");
			ps.setInt(1, ob.getIdDelStatus());
			ps.setString(2, ob.getStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

	/**
	 * Updating an existing DelStatus Entity in the database
     * @param ob Del Status
	 */
	@Override
	public void update(DelStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE del_status SET status = ? WHERE id_del_status = ?");
			ps.setString(1, ob.getStatus());
			ps.setInt(2, ob.getIdDelStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting a DelStatus Entity from the database
     * @param ob Del Status
     */
	@Override
	public void delete(DelStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM del_status WHERE id_del_status = ?");
			ps.setInt(1, ob.getIdDelStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing DelStatus Entity from the database
     * @param id int identifier
     * @return Del Status
     */
	@Override
	public DelStatus get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM del_status WHERE id_del_status = " + id);
			if(rs.next()) {
				return new DelStatus(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new DelStatus();
	}

    /**
     * Reading all existing DelStatus Entities from the database
     * @return List of Del Statuses
     */
	@Override
	public List<DelStatus> getAll() {
		ArrayList<DelStatus> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM del_status");
			while(rs.next()) {
				list.add(new DelStatus(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<DelStatus>();
	}
}
