package dao.impl;

import dao.BD;
import dao.IDAO;
import model.Odontologo;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoIDAOH2 implements IDAO<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoIDAOH2.class);
    private static final String SQL_INSERT_ODONTOLOGO="INSERT INTO odontologos (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Guardando Odontologo");
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,odontologo.getNombre());
            stmt.setString(2,odontologo.getApellido());
            stmt.setInt(3,odontologo.getMatricula());

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
                LOGGER.info("Odontologo guardado: " + odontologo.getId() + " "  + odontologo.getNombre());
            }

        }catch(Exception e){
            LOGGER.error("Error al guardar: " + e.getMessage());
        }finally {
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;

        List<Odontologo> pacienteList = new ArrayList<>();
        Odontologo paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Odontologos"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                paciente = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));

                pacienteList.add(paciente);

                System.out.println(paciente.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteList;
    }
}
