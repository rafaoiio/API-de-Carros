package br.com.RafaG.apidecarros.carros.service;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.RafaG.apidecarros.carros.domain.Carros;
import br.com.RafaG.apidecarros.carros.repository.CarrosRepository;
import br.com.RafaG.apidecarros.carros.request.CarrosCreateRequest;
import br.com.RafaG.apidecarros.carros.request.CarrosUpdateDocumentoRequest;
import br.com.RafaG.apidecarros.carros.request.CarrosUpdateRequest;
import br.com.RafaG.apidecarros.utils.ValidationUtil;
//import jakarta.validation.Validation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarrosService {

    private final CarrosRepository carrosRepository;

    public Carros listOne() {
        return new Carros("yrh", "Toyota", "Corola", 2020, 2021, "ABC1234", "123456" , "Vermelho", "1234567890");
    }
 
    //--//
 
    public Carros findById(final String id) {
        return carrosRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }
 
    //--//
 
    public Carros findByPlaca(final String placa) {
        return carrosRepository.findByPlaca(placa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }

    public Carros findByChassi(final String chassi) {
        return carrosRepository.findByChassi(chassi).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }
    



  public ArrayList<Carros> listAll() {
        final ArrayList<Carros> arrayDeCarros = (ArrayList<Carros>) carrosRepository.findAll();
 
        return arrayDeCarros;
    }
 
    //--//


 
    public Carros create(final CarrosCreateRequest carrosCreateRequest) {
        
    ValidationUtil.validate(carrosCreateRequest);
    final Carros carro = new Carros();

    carro.setMarca(carrosCreateRequest.getMarca());
    carro.setModelo(carrosCreateRequest.getModelo());

    carro.setAno_de_fabricacao(carrosCreateRequest.getAno_de_fabricacao());
    carro.setAno_do_modelo(carrosCreateRequest.getAno_do_modelo());

    carro.setPlaca(carrosCreateRequest.getPlaca());
    carro.setDocumento_do_proprietario(carrosCreateRequest.getDocumento_do_proprietario());
    carro.setCor(carrosCreateRequest.getCor());
    carro.setChassi(carrosCreateRequest.getChassi());


 
    return carrosRepository.save(carro);

    }




    //--//
 
    public void delete(final String id) {
        carrosRepository.delete(findById(id));
        if (carrosRepository.existsById(id))
            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pessoa não foi deletada");
    }
 
    //--//
 
    public void deleteByPlaca(final String placa) {
        delete(findByPlaca(placa).getId());
    }
 
    //--//
 
    public Carros update(final String id, final CarrosUpdateRequest carrosUpdateRequest) {
        ValidationUtil.validate(carrosUpdateRequest);
 
        final Carros carro = findById(id);
 
        carro.setMarca(carrosUpdateRequest.getMarca());
        carro.setModelo(carrosUpdateRequest.getModelo());

        carro.setAno_de_fabricacao(carrosUpdateRequest.getAno_de_fabricacao());
        carro.setAno_do_modelo(carrosUpdateRequest.getAno_do_modelo());

        carro.setPlaca(carrosUpdateRequest.getPlaca());
        carro.setDocumento_do_proprietario(carrosUpdateRequest.getDocumento_do_proprietario());
        carro.setCor(carrosUpdateRequest.getCor());
        carro.setChassi(carrosUpdateRequest.getChassi());


        return carrosRepository.save(carro);
    }
 
    //--//
 
    public Carros updateByPlaca(final String placa, CarrosUpdateRequest carrosUpdateRequest) {
        return update(findByPlaca(placa).getId(), carrosUpdateRequest);
    }
 
    //--//
 
    public Carros updateModelo(final String id, final CarrosUpdateDocumentoRequest carrosUpdateModeloRequest) {
        ValidationUtil.validate(carrosUpdateModeloRequest);
 
        final Carros carros = findById(id);
 
        carros.setDocumento_do_proprietario(carrosUpdateModeloRequest.getDocumento_do_proprietario());
 
        return carrosRepository.save(carros);
    }
 
    //--//
 
    public Carros updateModeloByPlaca(final String placa, final CarrosUpdateDocumentoRequest pessoaUpdateModeloRequest) {
        return updateModelo(findByPlaca(placa).getId(), pessoaUpdateModeloRequest);
    }






    
}

