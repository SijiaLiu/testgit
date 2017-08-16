package main.Service;

import main.Dao.Dao;
import main.DaoImpl.DaoImpl;
import main.Entity.Customer;
import main.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public class LoginService {
    private Dao dao = new DaoImpl();
    public boolean checkUser(Customer customer){
        Connection connection = null;
        try {
            ConnectionFactory cf = ConnectionFactory.getInstance();

            connection = cf.makeConnection();

            ResultSet rs = dao.findUserByName(connection, customer);
            while (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            try {
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
        return false;
    }
}
