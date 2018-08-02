package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.RequestStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Request Status entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoRequestStatus implements DaoEntity<RequestStatus> {

    /**
     * Writing  a new Request Status Entity into the database
     * @param ob RequestStatus
     */
	@Override
	public void insert(RequestStatus ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO request_status VALUES (?,?)");
			ps.setInt(1, ob.getIdRequestStatus());
			ps.setString(2, ob.getStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Updating an existing RequestStatus Entity in the database
     * @param ob RequestStatus
     */
	@Override
	public void update(RequestStatus ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			PreparedStatement ps = cn.prepareStatement("UPDATE request_status SET status = ? WHERE id_request_status = ?");
			ps.setString(1, ob.getStatus());
			ps.setInt(2, ob.getIdRequestStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Deleting a RequestStatus Entity from the database
     * @param ob RequestStatus
     */
	@Override
	public void delete(RequestStatus ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM request_status WHERE id_request_status = ?");
			ps.setInt(1, ob.getIdRequestStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Reading an existing RequestStatus Entity from the database
     * @param id int identifier
     */
	@Override
	public RequestStatus get(int id) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			ResultSet rs = new DbAccess().query("SELECT * FROM request_status WHERE id_request_status = " + id);
			if(rs.next()) {
				return new RequestStatus(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new RequestStatus();
	}

    /**
     * Reading all existing RequestStatus Entities from the database
     * @return List of RequestStatus
     */
	@Override
	public List<RequestStatus> getAll() {
		ArrayList<RequestStatus> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM request_status");
			while(rs.next()) {
				list.add(new RequestStatus(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new ArrayList<RequestStatus>();
	}
}
