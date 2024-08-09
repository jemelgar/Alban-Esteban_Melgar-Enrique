package dao.impl;

import dao.IDAO;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoIDAOArrayList implements IDAO<Odontologo> {
    private List<Odontologo> odontologos = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(OdontologoIDAOArrayList.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        LOGGER.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Odontologos listados: " + odontologos.size());
        return new ArrayList<>(odontologos);
    }
}
