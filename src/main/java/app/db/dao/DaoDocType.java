package app.db.dao;

import app.db.ConnectionPool;
import app.db.DbAccess;
import app.db.entity.DocType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accessing the data of Document Type entity
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class DaoDocType implements DaoEntity<DocType> {

	/**
	 * Writing  a new DocType Entity into the database
     * @param ob DocType
	 */
	@Override
	public void insert(DocType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO doc_type VALUES (?,?)");
			ps.setInt(1, ob.getIdDocType());
			ps.setString(2, ob.getDocument());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

	/**
	 * Updating an existing DocType Entity in the database
     * @param ob DocType
	 */
	@Override
	public void update(DocType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("UPDATE doc_type SET document = ? WHERE id_doc_type = ?");
			ps.setString(1, ob.getDocument());
			ps.setInt(2, ob.getIdDocType());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

	/**
	 * Deleting DocType Entity from the database
     * @param ob DocType
	 */
	@Override
	public void delete(DocType ob) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement ps = cn.prepareStatement("DELETE FROM doc_type WHERE id_doc_type = ?");
			ps.setInt(1, ob.getIdDocType());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
	}

    /**
     * Reading existing DocType Entity from the database
     * @param id int identifier
     * @return DocType
     */
	@Override
	public DocType get(int id) {
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM doc_type WHERE id_doc_type = " + id);
			if(rs.next()) {
				return new DocType(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return null;
	}

    /**
     * Reading all existing DocType Entities from the database
     * @return List of DocType
     */
	@Override
	public List<DocType> getAll() {
		ArrayList<DocType> list = new ArrayList<>();
		Connection cn = ConnectionPool.getInstance().getConnection();
		try {
			ResultSet rs = new DbAccess().query("SELECT * FROM doc_type");
			while(rs.next()) {
				list.add(new DocType(rs.getInt(1), rs.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().closeConnection(cn);
		}
		return null;
	}

}
