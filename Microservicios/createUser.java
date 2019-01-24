import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreateUser {

        private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_CONNECTION = "jdbc:mysql://ec2-18-220-153-82.us-east-2.compute.amazonaws.com:3306/Tickets";
        private static final String DB_USER = "remoteUser";
        private static final String DB_PASSWORD = "SNAGEM123";

        public static void main(String[] argv) {

                try {

                        insertUser();

                } catch (SQLException e) {

                        System.out.println(e.getMessage());

                }
 }

        private static void insertUser() throws SQLException {

                Connection dbConnection = null;
                Statement statement = null;

                String insertTableSQL = "INSERT INTO usuario VALUES"
                                + "('jpinargo','admin','Jorge','Pinargote','jpinargo@espol.edu.ec',md5('060795080'))" ;

                try {
                        dbConnection = getDBConnection();
                        statement = dbConnection.createStatement();

                        System.out.println(insertTableSQL);

                        // execute insert SQL stetement
                        statement.executeUpdate(insertTableSQL);

                        System.out.println("Record is inserted into DBUSER table!");
} catch (SQLException e) {

                        System.out.println(e.getMessage());

                } finally {

                        if (statement != null) {
                                statement.close();
                        }

                        if (dbConnection != null) {
                                dbConnection.close();
                        }

                }

        }

        private static Connection getDBConnection() {

                Connection dbConnection = null;
 try {

                        Class.forName(DB_DRIVER);

                } catch (ClassNotFoundException e) {

                        System.out.println(e.getMessage());

                }

                try {

                        dbConnection = DriverManager.getConnection(
                               DB_CONNECTION, DB_USER,DB_PASSWORD);
                        return dbConnection;

                } catch (SQLException e) {

                        System.out.println(e.getMessage());

                }

                return dbConnection;
       }

}

