package br.com.RafaG.apidecarros.carros.repository;
import java.util.Optional;
 
import org.springframework.data.repository.CrudRepository;

import br.com.RafaG.apidecarros.carros.domain.Carros;
 

 
public interface CarrosRepository extends CrudRepository<Carros, String> {
 
    Optional<Carros> findById(String id);

    Optional<Carros> findByPlaca(String placa);

    Optional<Carros> findByChassi(String chassi);


 
   Iterable<Carros> findAllByNomeContainsIgnoreCaseAndChassiContainsIgnoreCaseAndPlaca(String modelo, String marca, int ano_de_fabricacao, int ano_do_modelo, String placa,
   String documento_do_proprietario, String cor, String chassi);
}




