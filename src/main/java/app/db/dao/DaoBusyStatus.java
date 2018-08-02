package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.BusyStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Busy Status entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoBusyStatus implements DaoEntity<BusyStatus> {


	/**
	 * Writing  a new Busy Status Entity into the database
     * @param ob BusyStatus
	 */
	@Override
	public void insert(BusyStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO busy_status VALUES (?,?)");
			ps.setInt(1, ob.getIdBusyStatus());
			ps.setString(2, ob.getStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

	/**
	 * Updating an BusyStatus existing Entity in the database
     * @param ob BusyStatus
	 */
	@Override
	public void update(BusyStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE busy_status SET status = ? WHERE id_busy_status = ?");
			ps.setString(1, ob.getStatus());
			ps.setInt(2, ob.getIdBusyStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting an BusyStatus Entity from the database
     * @param ob BusyStatus
     */
	@Override
	public void delete(BusyStatus ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM busy_status WHERE id_busy_status = ?");
			ps.setInt(1, ob.getIdBusyStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing BusyStatus Entity from the database
     * @param id int idetifier
     * @return BusyStatus
     */
	@Override
	public BusyStatus get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM busy_status WHERE id_busy_status = " + id);
			if(rs.next()) {
				return new BusyStatus(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new BusyStatus();
	}

    /**
     * Reading all existing Entities from the database
     * @return List of BusyStatus
     */
	@Override
	public List<BusyStatus> getAll() {
		ArrayList<BusyStatus> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM busy_status");
			while(rs.next()) {
				list.add(new BusyStatus(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<BusyStatus>();
	}

}
