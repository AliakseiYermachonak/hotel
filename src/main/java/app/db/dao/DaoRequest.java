package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.Request;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Accessing the data of Request entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoRequest implements DaoEntity<Request> {

    /**
     * Writing a new Request Entity into the database
     * @param ob Request
     */
	@Override
	public void insert(Request ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps = cn.prepareStatement("INSERT INTO request VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, ob.getIdRequest());
			ps.setInt(2, ob.getIdUser());
			ps.setString(3, dateFormat.format(ob.getDate()));
			ps.setInt(4, ob.getDays());
			ps.setInt(5, ob.getIdRoomType());
			ps.setInt(6, ob.getRooms());
			ps.setInt(7, ob.getIdRequestStatus());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Writing a new Request Entity into the database by the parameters
     * @param id Request, date, room type identifiers, rooms identifiers, request status identifiers
     */
    public void insert(int id, Date date, int days, int idRoomType, int idRooms, int idRequestStatus) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = cn.prepareStatement("INSERT INTO request (id_user, date, days, id_room_type, " +
                    "rooms, id_request_status)"
                    + " VALUES (?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, dateFormat.format(date));
            ps.setInt(3, days);
            ps.setInt(4, idRoomType);
            ps.setInt(5, idRooms);
            ps.setInt(6, idRequestStatus);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
    }

    /**
     * Updating an existing Request Entity in the database
     * @param ob Request
     */
	@Override
	public void update(Request ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps = cn.prepareStatement("UPDATE request SET id_user = ?, date = ?, days = ?, id_room_type = ?, rooms = ?, id_request_status = ? WHERE id_request = ?");
			
			ps.setInt(1, ob.getIdUser());
			ps.setString(2, dateFormat.format(ob.getDate()));
			ps.setInt(3, ob.getDays());
			ps.setInt(4, ob.getIdRoomType());
			ps.setInt(5, ob.getRooms());
			ps.setInt(6, ob.getIdRequestStatus());
			ps.setInt(7, ob.getIdRequest());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Deleting an Request Entity from the database
     * @param ob Request
     */
	@Override
	public void delete(Request ob) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM request WHERE id_request = " + ob.getIdRequest());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Reading existing Request Entity from the database
     * @param id Request identifier
     * @return Request
     */
	@Override
	public Request get(int id) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM request WHERE id_request = " + id);
			if(rs.next()) {
			    Request request = new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				return request;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new Request();
	}

    /**
     * Reading all existing Request Entities from the database
     * @return List of Requests
     */
	@Override
	public List<Request> getAll() {
		ArrayList<Request> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM request");
			while(rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new ArrayList<Request>();
	}

    /**
     * Reading all existing new Request Entities from the database
     * @return List of new Requests
     */
	public List<Request> getAllNew() {
		ArrayList<Request> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM request WHERE id_request_status = 1 OR id_request_status = 5");
			while(rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return list;
	}

    /**
     * Reading all existing Request Entities from the database from the User
     * @param id User identifier
     * @return List of Requests th User
     */
	public List<Request> getAllUsers(int id) {
		ArrayList<Request> list = new ArrayList<>();
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM request WHERE id_user = " + id);
			while(rs.next()) {
				list.add(new Request(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return list;
	}
}
