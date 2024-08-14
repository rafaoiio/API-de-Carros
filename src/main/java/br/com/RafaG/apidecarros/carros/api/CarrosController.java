package br.com.RafaG.apidecarros.carros.api;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.RafaG.apidecarros.carros.domain.Carros;
import br.com.RafaG.apidecarros.carros.request.CarrosCreateRequest;
import br.com.RafaG.apidecarros.carros.request.CarrosUpdateDocumentoRequest;
import br.com.RafaG.apidecarros.carros.request.CarrosUpdateRequest;
import br.com.RafaG.apidecarros.carros.service.CarrosService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("carros")
public class CarrosController {
    private final CarrosService carrosService;

    @GetMapping("/carros")
    public ResponseEntity<Carros> listOne() {
        return new ResponseEntity<Carros>(carrosService.listOne(), HttpStatus.OK);
    }
 
    @GetMapping("/id/{id}")
    public ResponseEntity<Carros> findById(@PathVariable(value = "id", required = true) final String id) {
        return new ResponseEntity<Carros>(carrosService.findById(id), HttpStatus.OK);
    }
 
    @GetMapping("/placa/{placa}")
    public ResponseEntity<Carros> findByPlaca(@PathVariable(value = "placa", required = true) final String placa) {
        return new ResponseEntity<Carros>(carrosService.findByPlaca(placa), HttpStatus.OK);
    }

    @GetMapping("/chassi/{chassi}")
    public ResponseEntity<Carros> findByChassi(@PathVariable(value = "chassi", required = true) final String placa) {
        return new ResponseEntity<Carros>(carrosService.findByChassi(placa), HttpStatus.OK);
    }
 
    @GetMapping("")
    public ResponseEntity<ArrayList<Carros>> listAll() {
        return new ResponseEntity<ArrayList<Carros>>(carrosService.listAll(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Carros> create(@RequestBody(required = true) final CarrosCreateRequest pessoaCreateRequest) {
        return new ResponseEntity<Carros>(carrosService.create(pessoaCreateRequest), HttpStatus.CREATED);
    }
 
    //_____________________________________________________________________________________________________
 
    // método DELETE
 
    @DeleteMapping("/id/carros/{id}")
    public ResponseEntity<Carros> deleteById(@PathVariable(value = "id", required = true) final String id) {
        carrosService.delete(id);
        return ResponseEntity.noContent().header(HttpHeaders.CONTENT_LENGTH, "0").build();
    }
 
    @DeleteMapping("/placa/carros/{placa}")
    public ResponseEntity<Carros> deleteByPlaca(@PathVariable(value = "placa", required = true) final String placa) {
        carrosService.deleteByPlaca(placa);
        return ResponseEntity.noContent().header(HttpHeaders.CONTENT_LENGTH, "0").build();
    }

    @DeleteMapping("/chassi/carros/{chassi}")
    public ResponseEntity<Carros> deleteByChassi(@PathVariable(value = "placa", required = true) final String placa) {
    carrosService.deleteByPlaca(placa);
    return ResponseEntity.noContent().header(HttpHeaders.CONTENT_LENGTH, "0").build();
    }
 
    //_______________________________________________________________________________________________________
 
    // método PATCH
 
    @PatchMapping("/transferência/carros/id/{id}")
    public ResponseEntity<Carros> updateNome(@PathVariable(value = "id", required = true) final String id,
    @RequestBody(required = true) final CarrosUpdateDocumentoRequest carrosUpdateModeloRequest) {
    return new ResponseEntity<Carros>(carrosService.updateModelo(id, carrosUpdateModeloRequest), HttpStatus.OK);
    }
 
    @PatchMapping("/transferência/carros/placa/{placa}")
    public ResponseEntity<Carros> updateNomeByCpf(@PathVariable(value = "placa", required = true) final String placa,
    @RequestBody(required = true) final CarrosUpdateDocumentoRequest carrosUpdateModeloRequest) {
    return new ResponseEntity<Carros>(carrosService.updateModeloByPlaca(placa, carrosUpdateModeloRequest), HttpStatus.OK);
    }

    @PatchMapping("/transferência/carros/chassi/{chassi}")
    public ResponseEntity<Carros> updateNomeByChassi(@PathVariable(value = "placa", required = true) final String placa,
    @RequestBody(required = true) final CarrosUpdateDocumentoRequest carrosUpdateModeloRequest) {
    return new ResponseEntity<Carros>(carrosService.updateModeloByPlaca(placa, carrosUpdateModeloRequest), HttpStatus.OK);
    }

 
    // ________________________________________________________________________________________________________
 
    // método PUT
 
    @PutMapping("/id/carros/{id}")
    public ResponseEntity<Carros> update(@PathVariable(value = "id", required = true) final String id,
    @RequestBody(required = true) final CarrosUpdateRequest carrosUpdateRequest) {
    return new ResponseEntity<Carros>(carrosService.update(id, carrosUpdateRequest), HttpStatus.OK);
    }
 
    @PutMapping("/placa/carros/{placa}")
    public ResponseEntity<Carros> updateByPlaca(@PathVariable(value = "placa", required = true) final String placa,
    @RequestBody(required = true) final CarrosUpdateRequest carrosUpdateRequest) {
    return new ResponseEntity<Carros>(carrosService.updateByPlaca(placa, carrosUpdateRequest), HttpStatus.OK);
    }

    @PutMapping("/chassi/carros/{chassi}")
    public ResponseEntity<Carros> updateByChassi(@PathVariable(value = "chassi", required = true) final String placa,
    @RequestBody(required = true) final CarrosUpdateRequest carrosUpdateRequest) {
    return new ResponseEntity<Carros>(carrosService.updateByPlaca(placa, carrosUpdateRequest), HttpStatus.OK);
    }
}


