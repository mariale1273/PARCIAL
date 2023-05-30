
package proyectomundial.DAO;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import proyectomundial.model.User;
import proyectomundial.util.BasedeDatos;


/**
 *
 * @author mkami
 */
public class UserDao {
    public UserDao() {
        BasedeDatos.conectar();
    }
    public List<User> getUsers(){
        
        String sql = "SELECT username, password FROM poo.users";
        List<User> users = new ArrayList<User>();
        
        try {
            ResultSet result = BasedeDatos.ejecutarSQL(sql);
            
            if(result != null) {
            
                while (result.next()) { 
                    User seleccion = new User(result.getString("username"), result.getString("password"));
                    users.add(seleccion);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("Error consultando users");
        }
        
        return users;
    }
}
