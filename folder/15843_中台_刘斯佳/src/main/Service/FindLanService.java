package main.Service;

import main.Dao.Dao;
import main.DaoImpl.DaoImpl;
import main.Entity.Film;
import main.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class FindLanService {
    private Dao dao = new DaoImpl();

    List<Film> list = new ArrayList<Film>();

    public List<Film> findLan(){

        Connection connection = null;

        connection = ConnectionFactory.getInstance().makeConnection();

        try {
            list = dao.findLanguage(connection);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("五事务回调");
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
        return list;
    }
}