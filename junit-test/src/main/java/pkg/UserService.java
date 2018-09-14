package pkg;

import java.sql.SQLException;

public class UserService {

    private DBService dbService = new DBService();

    public String  getSSN(String username) {
        try {
            User u = dbService.getUser(username);

            return u.getSsn();
        } catch (SQLException e){
            return "";
        }
    }

}
