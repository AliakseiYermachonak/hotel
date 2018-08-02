package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.Busyness;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Accessing the data of Busyness entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoBusyness implements DaoEntity<Busyness> {

    /**
     * Writing  a new Busyness Entity into the database
     * @param ob Busyness
     */
	@Override
	public void insert(Busyness ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps = cn.prepareStatement("INSERT INTO busyness VALUES (?,?,?,?,?)");
			ps.setInt(1, ob.getIdRoom());
			ps.setString(2, dateFormat.format(ob.getDate()));
			ps.setInt(3, ob.getIdBusyStatus());
            ps.setInt(4, ob.getIdDocType());
            ps.setString(5, ob.getDocNumber());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Updating an existing Busyness Entity in the database
     * @param ob Busyness
     */
	@Override
	public void update(Busyness ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			if (ob.getIdDocType() == 0) {
				PreparedStatement ps = cn.prepareStatement("UPDATE busyness SET id_busy_status = ?" +
						"  WHERE id_room = ? AND date = ?");
				ps.setInt(1, ob.getIdBusyStatus());
				ps.setInt(2, ob.getIdRoom());
				ps.setString(3, dateFormat.format(ob.getDate()));

				ps.execute();
			} else {

				PreparedStatement ps = cn.prepareStatement("UPDATE busyness SET id_busy_status = ?, doc_type = ?, doc_number = ?" +
						"  WHERE id_room = ? AND date = ?");
				ps.setInt(1, ob.getIdBusyStatus());
				ps.setInt(2, ob.getIdDocType());
				ps.setString(3, ob.getDocNumber());
				ps.setInt(4, ob.getIdRoom());
				ps.setString(5, dateFormat.format(ob.getDate()));

				ps.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Deleting the Busyness Entity from the database
     * @param ob Busyness
     */
	@Override
	public void delete(Busyness ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps = cn.prepareStatement("DELETE FROM busyness WHERE id_room = ? AND date = ?");
			ps.setInt(1, ob.getIdRoom());
			ps.setString(2, dateFormat.format(ob.getDate()));

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
	}

    /**
     * Reading existing Busyness Entity from the database
     * @param id int room identifier
     * @return Busyness
     */
	@Override
	public Busyness get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM busyness WHERE id_room = " + id);
			if(rs.next()) {
				return new Busyness(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new Busyness();
	}

    /**
     * Reading existing Busyness Entity from the database
     * @param id int room identifier and Date date of Busyness
     * @return Busyness
     */
	public Busyness get(int id, Date date) {
		Connection cn = ConnectionPool.getInstance().getConnection();
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM busyness WHERE id_room = " + id + " AND date = " + dateFormat.format(date));
			if(rs.next()) {
				return new Busyness(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new Busyness();
	}

    /**
     * Reading all existing Entities from the database
     * @return List of existing Busyness entities
     */
	@Override
	public List<Busyness> getAll() {
		ArrayList<Busyness> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM busyness");
			while(rs.next()) {
				list.add(new Busyness(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new ArrayList<Busyness>();
	}

    /**
     * Reading all existing Entities from the database
     * after today.
     * @return List of existing Busyness entities
     */
	public List<Busyness> getAllAfterNow() {
		ArrayList<Busyness> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM busyness WHERE date>=CURRENT_DATE()");
			while(rs.next()) {
				list.add(new Busyness(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            ConnectionPool.getInstance().closeConnection(cn);
        }
		return new ArrayList<Busyness>();
	}
}
