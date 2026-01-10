package com.controleestoque.controller.cdc;

import com.controleestoque.domain.cdc.CdcService;
import com.controleestoque.domain.cdc.model.Cdc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cdc")
public class CdcController {

    @Autowired
    private CdcService cdcservice;

    @GetMapping
    public ResponseEntity<List<Cdc>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(cdcservice.buscarTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<List<Cdc>> buscarCodigo(@PathVariable("codigo") String codigo){
        return ResponseEntity.status(HttpStatus.OK).body(cdcservice.buscarCodigo(codigo));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Cdc>> buscarAtivosInativos(@PathVariable("status") boolean status){
        return ResponseEntity.status(HttpStatus.OK).body(cdcservice.buscarAtivosInativos(status));
    }

}
