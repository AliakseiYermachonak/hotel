package app.db.dao;

import app.db.ConnectionPool;
import app.db.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Order entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoOrder implements DaoEntity<Order> {

    /**
     * Writing  a new Order Entity into the database
     * @param ob Order
     */
	@Override
	public void insert(Order ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO orders VALUES (?,?,?,?,?)");
			ps.setInt(1, ob.getIdOrder());
			ps.setInt(2, ob.getIdRequest());
			ps.setFloat(3, ob.getDisount());
			ps.setFloat(4, ob.getPrice());
			ps.setInt(5, ob.getIdRoom());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}
    /**
     * Writing  a new Order Entity into the database by its parameters
     * @param idRequest, discount, price, id_room
     */
	public void insert(int idRequest, float discount, float price, int id_room) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO orders (id_request, discount, price, id_room) " +
					"VALUE (?,?,?,?)");
			ps.setInt(1, idRequest);
			ps.setFloat(2, discount);
			ps.setFloat(3, price);
			ps.setInt(4, id_room);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Updating an existing Order Entity in the database
     * @param ob Order
     */
	@Override
	public void update(Order ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE orders SET id_request = ?, discount = ?, price = ?, id_room = ? WHERE id_order = ?");
			ps.setInt(1, ob.getIdRequest());
			ps.setFloat(2, ob.getDisount());
			ps.setFloat(3, ob.getPrice());
			ps.setInt(4, ob.getIdRoom());
			ps.setInt(5, ob.getIdOrder());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Deleting an Order Entity from the database
     * @param ob Order
     */
	@Override
	public void delete(Order ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM orders WHERE id_order = ?");
			ps.setInt(1, ob.getIdOrder());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing Order Entity from the database
     * @param id Order identifier
     * @return Order
     */
	@Override
	public Order get(int id) {
		ArrayList<Order> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM orders WHERE id_order = " + id);
			if(rs.next()) {
				return new Order(rs.getInt(1), rs.getInt(2), rs.getFloat(3),  rs.getFloat(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return null;
	}

    /**
     * Reading all existing Order Entities from the database
     * @return List of Orders
     */
	@Override
	public List<Order> getAll() {
		ArrayList<Order> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM orders");
			while(rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getFloat(3),  rs.getFloat(4), rs.getInt(5)));
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
