package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Singleton class to make a set of connections
 * and provide this connections on request
 * @author Alexey Yermachyonok
 * @version 1.0
 */

public class ConnectionPool{

    private static volatile ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;
    private ResourceBundle resourceBundle;

    /**
     * Returns the only one ConnectionPool object.
     * @return CommandFactory singleton.
     */
    public static ConnectionPool getInstance() {
        if(instance == null){
            synchronized(ConnectionPool.class) {
                if (instance == null) instance = new ConnectionPool(5);
            }
        } return instance;
    }

    public ConnectionPool(final int POOL_SIZE) {
        resourceBundle = ResourceBundle.getBundle("db");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("login");
        String password = resourceBundle.getString("password");
        try {
            Class.forName(resourceBundle.getString("driver"));
        connectionQueue = new ArrayBlockingQueue<Connection> (POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection = DriverManager.getConnection(url, user, password);
            connectionQueue.offer(connection);
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to get the connection.
     * @return Connection
     */
    public Connection getConnection()  {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Method to return the connection to the pool.
     * @return CommandFactory singleton.
     */
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connectionQueue.put(connection);
            } catch (InterruptedException e) {
            }
        }
    }
}