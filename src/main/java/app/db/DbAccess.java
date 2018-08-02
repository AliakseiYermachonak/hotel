package app.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for direct connection to the database with a script
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DbAccess {

	private static final Logger LOGGER = Logger.getLogger(DbAccess.class);

    /**
     * Method to access Database with a direct SQL script
     * @param sql script
     */
	public void update(String sql) {
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Method to access Database with a direct SQL script
     * @param sql script
     * @return String
     */
	public String queryRoomNumbers(String sql) {
        String idRooms = "";
		ResultSet rs = null;
        Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			rs = st.executeQuery(sql);
            while(rs.next()) {
                idRooms = idRooms + rs.getInt(1) + "; ";
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    ConnectionPool.getInstance().closeConnection(cn);
        }
		return idRooms;
	}

    /**
     * Method to access Database with a direct SQL script
     * @param sql script
     * @return ResultSet of the SQL script
     */
    public ResultSet query(String sql) {
        ResultSet rs = null;
        Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
        return rs;
    }

    /**
     * Method to access Database with a direct SQL script
     * and get available rooms for the given parameters
     * @param idRoomType identifier of the type of the room,
     * @param date in String type to check
     * @param days int how long do the guest wants to stay
     * @return String available rooms
     */
	public String getAvailableRooms(int idRoomType, String date, int days){
        String sql = "SELECT id_room FROM busyness INNER JOIN" +
                " room USING (id_room) WHERE room.id_room_type=" + idRoomType +
                "&&busyness.id_busy_status=1" +
                "&&busyness.date='" + date +
                "';";
        String number = queryRoomNumbers(sql);
        return number;
    }
}
