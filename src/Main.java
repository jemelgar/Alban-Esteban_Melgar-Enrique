import dao.BD;
import dao.impl.OdontologoIDAOArrayList;
import dao.impl.OdontologoIDAOH2;
import model.Odontologo;
import service.OdontologoService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        OdontologoService odontologoService = new OdontologoService();
        OdontologoIDAOArrayList listaOdontologos = new OdontologoIDAOArrayList();
        BD.ejecutarSQL();

        Odontologo odontologo1 = new Odontologo(123,"Ana", "Martínez");
        Odontologo odontologo2 = new Odontologo(456,"Jorge", "Sánchez");

        odontologoService.setOdontologoIDAO(new OdontologoIDAOH2());
        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);
        odontologoService.listarTodos();

        odontologoService.setOdontologoIDAO(new OdontologoIDAOArrayList());
        listaOdontologos.guardar(odontologo1);
        listaOdontologos.guardar(odontologo2);

        List<Odontologo> odontologos = listaOdontologos.listarTodos();
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo);
        }

    }
}
