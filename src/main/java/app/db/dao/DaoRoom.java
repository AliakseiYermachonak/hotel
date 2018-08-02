package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Room entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoRoom implements DaoEntity<Room> {

    /**
     * Writing a new Room Entity into the database
     * @param ob Room
     */
	@Override
	public void insert(Room ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO room VALUES (?,?)");
			ps.setInt(1, ob.getIdRoom());
			ps.setInt(2, ob.getIdRoomType());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Updating an existing Room Entity in the database
     * @param ob Room
     */
	@Override
	public void update(Room ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE room SET id_room_type = ? WHERE id_room = ?");
			ps.setInt(1, ob.getIdRoomType());
			ps.setInt(2, ob.getIdRoom());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting an Entity from the database
     * @param ob Room
     */
	@Override
	public void delete(Room ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM room WHERE id_room = ?");
			ps.setInt(1, ob.getIdRoom());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing Room Entity from the database
     * @param id int identifier
     * @return Room
     */
	@Override
	public Room get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM room WHERE id_room = " + id);
			if(rs.next()) {
				return new Room(rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new Room();
	}

    /**
     * Reading all existing Room Entities from the database
     * @return List of Rooms
     */
	@Override
	public List<Room> getAll() {
		ArrayList<Room> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM room");
			while(rs.next()) {
				list.add(new Room(rs.getInt(1), rs.getInt(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<Room>();
	}

    /**
     * Reading all existing Room Entities from the database by type of the Room
     * @param idRoomType int room type identifier
     * @return List of Rooms
     */
	public List<Room> getByType(int idRoomType) {
		ArrayList<Room> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM room WHERE id_room_type=" + idRoomType);
			while(rs.next()) {
				list.add(new Room(rs.getInt(1), rs.getInt(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<Room>();
	}
}
