import java.sql.*;

public class mostrarAsientos{

        public String mostrarAsientos (String username, String password, int id_localidad, int id_evento){
                int id_venue = 0;
                String filas = "";
                String columnas = "";
                String matriz = "";

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
                        ResultSet rest = statement.executeQuery("SELECT * FROM evento where id="+id_evento);
                        if (rest.next()){
                                id_venue = rest.getInt("id_venue");             
                        }
                         ResultSet rs = statement.executeQuery("SELECT * FROM venue_localidad where id_venue="+id_venue+" and id_localidad="+id_localidad);
                        if (rs.next()) {
                                int num_filas = rs.getInt("num_filas");
                                int num_columnas = rs.getInt("num_columnas");
                                System.out.println(num_filas);
                                System.out.println(num_columnas);
                                filas = Integer.toString(num_filas);
                                columnas = Integer.toString(num_columnas);
                        }else{
 				System.out.println("no se ha encontrado las coincidencias");
                        }
                matriz = filas + columnas;
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
        return matriz;
        }

        public static void main(String[] args) {
                String hola;
                mostrarAsientos javaMySQLBasic = new mostrarAsientos();
                hola = javaMySQLBasic.mostrarAsientos("alanmend","asd123",1,1);
                System.out.print(hola);
        }
}
