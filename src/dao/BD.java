package dao;

import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    private static final Logger LOGGER = Logger.getLogger(BD.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./src/database/odontologo";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public static Connection getConnection() throws Exception {
        LOGGER.info("Levantamos la conexión a la BD");
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

    public static void ejecutarSQL() throws Exception {
        String rutaArchivoSQL = "G:/DH/Bim05/examen/evaluacion/src/dao/CREATE_TABLE_ODONTOLOGOS.sql";
        //System.out.println("Ruta absoluta: " + Paths.get(rutaArchivoSQL).toAbsolutePath().toString());

        try (Connection connection =getConnection();
             Statement statement = connection.createStatement()) {

            String scriptSQL = new String(Files.readAllBytes(Paths.get(rutaArchivoSQL)));
            System.out.println(scriptSQL);
            String[] instrucciones = scriptSQL.split(";");

            for (String instruccion : instrucciones) {
                if (!instruccion.trim().isEmpty()) {
                    statement.execute(instruccion.trim());
                }
            }

            System.out.println("Script SQL ejecutado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }


