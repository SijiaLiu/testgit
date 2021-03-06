package main.Service;

import main.Dao.Dao;
import main.DaoImpl.DaoImpl;
import main.Entity.Film;
import main.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class UpdateService {
    private Dao dao = new DaoImpl();

    public void Update(Film film){
        Connection connection = null;
        connection = ConnectionFactory.getInstance().makeConnection();

        try {
            dao.update(connection, film);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("三事务回调");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
