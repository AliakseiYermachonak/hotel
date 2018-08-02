package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.RoomType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Room Type entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoRoomType implements DaoEntity<RoomType> {

    /**
     * Writing a new RoomType Entity into the database
     * @param ob RoomType
     */
	@Override
	public void insert(RoomType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO room_type VALUES (?,?,?)");
			ps.setInt(1, ob.getIdRoomType());
			ps.setString(2, ob.getType());
			ps.setFloat(3, ob.getPrice());
			
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Updating an existing RoomType Entity in the database
     * @param ob RoomType
     */
	@Override
	public void update(RoomType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE room_type SET type = ?, price = ? WHERE id_room_type = ?");
			ps.setString(1, ob.getType());
			ps.setFloat(2, ob.getPrice());
			ps.setInt(3, ob.getIdRoomType());
			
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting a RoomType Entity from the database
     * @param ob RoomType
     */
	@Override
	public void delete(RoomType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM room_type WHERE id_room_type = ?");
			ps.setInt(1, ob.getIdRoomType());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing RoomType Entity from the database
     * @param id int identifier
     * @return RoomType
     */
	@Override
	public RoomType get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM room_type WHERE id_room_type = " + id);
			if(rs.next()) {
				return new RoomType(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new RoomType();
	}

    /**
     * Reading all existing Entities from the database
     * @return List of RoomType
     */
	@Override
	public List<RoomType> getAll() {
		ArrayList<RoomType> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM room_type");
			while(rs.next()) {
				list.add(new RoomType(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return new ArrayList<RoomType>();
	}
}
