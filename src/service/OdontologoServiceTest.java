package service;

import dao.BD;
import dao.impl.OdontologoIDAOArrayList;
import dao.impl.OdontologoIDAOH2;
import model.Odontologo;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


public class OdontologoServiceTest {
    private OdontologoService odontologoService;



    @Before
    public void initDB() throws Exception {
        BD.ejecutarSQL();
        odontologoService = new OdontologoService();
        /*
        Odontologo odontologo3 = odontologoService.guardar(new Odontologo(123,"Ana", "Martínez"));
        Odontologo odontologo4 = odontologoService.guardar(new Odontologo(123,"Jorge", "Perez"));*/

    }

    @Test
    public void listarTodos() {
        OdontologoService odontologoService1 = new OdontologoService();
        OdontologoService odontologoService2 = new OdontologoService();
        Odontologo odontologo1 = new Odontologo(123,"Diego", "Hernandez");
        Odontologo odontologo2 = new Odontologo(456,"Andrea", "Sánchez");

        odontologoService1.setOdontologoIDAO(new OdontologoIDAOArrayList());
        odontologoService1.guardar(odontologo1);
        odontologoService1.guardar(odontologo2);
        assertTrue(odontologoService1.listarTodos().size() == 2);

        odontologoService2.setOdontologoIDAO(new OdontologoIDAOH2());
        odontologoService2.guardar(odontologo1);
        odontologoService2.guardar(odontologo2);

        assertTrue(odontologoService2.listarTodos().size() == 2);
    }
}