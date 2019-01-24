import java.sql.*;

public class connection{

        public static void main(String[] args) throws Exception {

                System.out.println("----MySQL JDBC Connection Testing -------");

                 try {
                        Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {

                        System.out.println("Where is your MySQL JDBC Driver?");
                        e.printStackTrace();
                        return;
                }

                System.out.println("MySQL JDBC Driver Registered!");
                Connection connection = null;

                try {
                        connection = DriverManager.getConnection("jdbc:mysql://ec2-18-220-153-82.us-east-2.compute.amazonaws.com:3306/Tickets", "remoteUser","SNAGEM123");
                } catch (SQLException e) {
                        System.out.println("Connection Failed!:\n" + e.getMessage());
                }

                if (connection != null) {
                        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
                } else {
                        System.out.println("FAILURE! Failed to make connection!");
                }
        }
}
