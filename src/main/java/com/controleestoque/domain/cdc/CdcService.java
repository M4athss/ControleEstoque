package com.controleestoque.domain.cdc;

import com.controleestoque.controller.cdc.CdcRequest;
import com.controleestoque.controller.cdc.CdcRespose;
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


    public Cdc buscarCodigo(String codigo){
        CdcEntity repo = cdcrepository.findByCodigo(codigo);
        return  new Cdc(repo.getCodigo(), repo.getNome(), repo.getStatus());
    }

    public List<Cdc> buscarAtivosInativos(boolean status) {
        List<CdcEntity> repo = cdcrepository.findByStatus(status);
        return repo.stream()
                .map(Cdc::new)
                .toList();
    }

    public void salvarCdc(CdcRequest cdc){
        if (cdc.codigo().length() > 3 || cdc.codigo() == null || cdc.nome() == null) {
            throw new IllegalArgumentException("valores invalidos, apenas codigo com 3 caracteres e valores nao nulos");
        } else {
            CdcEntity repo = new CdcEntity(cdc.codigo(),cdc.nome(),true);
            cdcrepository.save(repo);
        }
    }

    public CdcRespose atualizarNome(CdcRequest cdc){
        CdcEntity novo = new CdcEntity(cdc.codigo(),cdc.nome());
        CdcEntity repo = cdcrepository.findByCodigo(novo.getCodigo());
        repo.setNome(novo.getNome());
        cdcrepository.save(repo);
        return new CdcRespose(repo.getCodigo(), repo.getNome(),repo.getStatus());
    }


}
