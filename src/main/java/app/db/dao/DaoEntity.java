package app.db.dao;

import java.util.List;

/**
 * Basic interface for accessing the data
 * from the DataBase.
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public interface DaoEntity<T>{

    /**
     * Writing  a new Entity into the database
     */
	void insert(T ob);

    /**
     * Updating an existing Entity in the database
     */
	void update(T ob);

    /**
     * Deleting an Entity from the database
     */
	void delete(T ob);

    /**
     * Reading existing Entity from the database
     */
	T get(int id);

    /**
     * Reading all existing Entities from the database
     */
	List<T> getAll();
}