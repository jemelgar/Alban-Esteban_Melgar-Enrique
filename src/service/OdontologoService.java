package service;

import dao.IDAO;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDAO<Odontologo> odontologoIDAO;

    public IDAO<Odontologo> getOdontologoIDAO() {
        return odontologoIDAO;
    }

    public void setOdontologoIDAO(IDAO<Odontologo> odontologoIDAO) {
        this.odontologoIDAO = odontologoIDAO;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDAO.guardar(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return odontologoIDAO.listarTodos();
    }
}
