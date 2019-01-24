import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;

public class mostrarEventos{

        public String mostrarAsientos (String username, String password, int id_evento){

                ArrayList<String> localidades = new ArrayList<>();
                ArrayList<Float> precios = new ArrayList<>();
                ArrayList<Integer> idLocalidades = new ArrayList<>();
                Date fechaEvento;
                String nombreEvento;
                int id_venue;
                String descripcionEvento;

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
                    connection = DriverManager.getConnection("jdbc:mysql://ec2-18-188-79-218.us-east-2.compute.amazonaws.com:3306/Tickets", "remoteUser","SNAGEM123");

                        Statement statement = connection.createStatement();
                        ResultSet rest = statement.executeQuery("SELECT * FROM evento where id="+id_evento);
                        if (rest.next()){
                                nombreEvento = rest.getString("nombre");
                                fechaEvento = rest.getDate("fecha_evento");
                                id_venue = rest.getInt("id_venue");
                                descripcionEvento = rest.getString("descripcion");
                        }
 System.out.println("Where is your MySQL JDBC Driver?");
                        e.printStackTrace();
                }

                System.out.println("MySQL JDBC Driver Registered!");
                Connection connection = null;

                try {
                    connection = DriverManager.getConnection("jdbc:mysql://ec2-18-188-79-218.us-east-2.compute.amazonaws.com:3306/Tickets", "remoteUser","SNAGEM123");

                        Statement statement = connection.createStatement();
                        ResultSet rest = statement.executeQuery("SELECT * FROM evento where id="+id_evento);
                        if (rest.next()){
                                nombreEvento = rest.getString("nombre");
                                fechaEvento = rest.getDate("fecha_evento");
                                id_venue = rest.getInt("id_venue");
                                descripcionEvento = rest.getString("descripcion");
                        }
                        ResultSet restPrecio = statement.executeQuery("SELECT * FROM precio where id_evento="+id_evento);
                        while (restPrecio.next()) {
                                float valorLocalidad = restPrecio.getFloat("valor");
                                precios.add(valorLocalidad);
                                int id_localidad = restPrecio.getInt("id_localidad");
                                idLocalidades.add(id_localidad);
                        }
                        for (int a = 0 ; a<idLocalidades.size() ; a++){
                                int id_localidad = idLocalidades.get(a);
                                ResultSet restLocalidad = statement.executeQuery("SELECT * FROM localidad where id="+id_localidad);
                                if (restLocalidad.next()) {
                                        localidades.add(restLocalidad.getString("nombre"));
                                }
                                restLocalidad.close();
                        }
                rest.close();
                restPrecio.close();
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
                mostrarEventos javaMySQLBasic = new mostrarEventos();
                hola = javaMySQLBasic.mostrarAsientos("alanmend","asd123",1);
                System.out.print(hola);
        }
}

