package es.dtgz.myGarajeBoot.service;

import es.dtgz.myGarajeBoot.model.Moto;
import es.dtgz.myGarajeBoot.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAllMotos() {
        return motoRepository.findAll();
    }

    public Optional<Moto> getMotoById(Long id) {
        return motoRepository.findById(id);
    }

    public Moto saveMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deleteMoto(Long id) {
        motoRepository.deleteById(id);
    }
}