package com.repository.Service;

import com.repository.Controller.CocheInput;
import com.repository.Controller.CocheOutput;
import com.repository.Controller.CocheOutputMatricula;
import com.repository.Domain.Coche;
import com.repository.Exception.AlreadyExistsException;
import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NotExistsException;
import com.repository.Exception.NullException;
import com.repository.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    public List<CocheOutput> getCoches() throws IsEmptyException, NullException {
        List<Coche> coches = cocheRepository.findAll();
        List<CocheOutput> cochesOutput = new ArrayList<>();
        for (Coche coche : coches) {
            cochesOutput.add(CocheOutput.getCoche(coche));
        }
        return cochesOutput;
    }

    public CocheOutputMatricula getCocheId(String matricula) throws IsEmptyException, NullException, NotExistsException {
        if (cocheRepository.findById(matricula).isPresent())
            return new CocheOutputMatricula(matricula);
        else throw new NotExistsException("El coche no existe");
    }

    public void anyadirCoche(CocheInput input) throws AlreadyExistsException, IsEmptyException, NullException {
        Coche c = CocheInput.getCoche(input);
        if (cocheRepository.findById(input.getMatricula()).isPresent())
            throw new AlreadyExistsException("El coche ya existe");
        cocheRepository.save(c);
    }
}

