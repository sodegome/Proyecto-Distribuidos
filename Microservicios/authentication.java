import java.sql.*;

public class authentication{

        public String authe (String username, String password){

                System.out.println("----MySQL JDBC Connection Testing -------");
                 try {
                        Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {

                        System.out.println("Where is your MySQL JDBC Driver?");
                        e.printStackTrace();
                }

                System.out.println("MySQL JDBC Driver Registered!");
                Connection connection = null;

                try {
                    connection = DriverManager.getConnection("jdbc:mysql://ec2-18-217-64-116.us-east-2.compute.amazonaws.com:3306/Tickets", "remoteUser","SNAGEM123");

                        Statement statement = connection.createStatement();
                         ResultSet rs = statement.executeQuery("SELECT * FROM usuario where id_username='"+ username +"'and password=md5('" +password+"')");
                        if (rs.next()) {
                                String id_username = rs.getString("id_username");
                                System.out.println("acceso accedido");
                        }else{
                                System.out.println("error de contrasenia");
                        }
                rs.close();
                statement.close();
                connection.close();


                } catch (SQLException e) {
                        System.out.println("Connection Failed!:\n" + e.getMessage());
                }

                if (connection != null) {
                        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
                } else {
                        System.out.println("FAILURE! Failed to make connection!");
                }
  	return null;
        }

        public static void main(String[] args) {
                String hola;
                authentication javaMySQLBasic = new authentication();
                hola = javaMySQLBasic.authe("alanmend","asd123");
                System.out.print(hola);
        }
}
