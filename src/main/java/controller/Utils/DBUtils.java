package controller.Utils;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    public static User findUser(Connection conn, String userName,
                                String mail, String password) throws SQLException {

        String sql = "Select a.User_Name, a.Mail, a.Password  from table_name a " //
                + " where a.User_Name = ? and a.Mail = ? and a.passw  ord= ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, mail);
        pstm.setString(3, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            user.setMail(mail);
            return user;
        }
        return null;
    }

    public static User findUser(Connection conn, String userName) throws SQLException {

        String sql = "Select a.User_Name, a.Password, a.Mail from User_Account a "//
                + " where a.User_Name = ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String password = rs.getString("Password");
            String mail = rs.getString("Mail");
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            user.setMail(mail);
            return user;
        }
        return null;
    }
}
