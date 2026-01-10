package com.controleestoque.domain.cdc;

import com.controleestoque.domain.cdc.model.Cdc;
import com.controleestoque.infra.persistence.h2.cdc.CdcEntity;
import com.controleestoque.infra.persistence.h2.cdc.CdcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Service
public class CdcService {

    @Autowired
    private CdcRepository cdcrepository;

    //BUSCA TODOS OS CDCS CADASTRADOS
    public List<Cdc> buscarTodos(){
        List<CdcEntity> repo = cdcrepository.findAll();
        List<Cdc> cdc = repo.stream()
                .map(Cdc::new)
                .toList();
        return cdc;
    }


    public List<Cdc> buscarCodigo(String codigo){
        List<CdcEntity> repo = cdcrepository.findByCodigo(codigo);
        return repo.stream()
                .map(Cdc :: new)
                .toList();
    }

    public List<Cdc> buscarAtivosInativos(boolean status) {
        List<CdcEntity> repo = cdcrepository.findByStatus(status);
        return repo.stream()
                .map(Cdc::new)
                .toList();
    }


}
