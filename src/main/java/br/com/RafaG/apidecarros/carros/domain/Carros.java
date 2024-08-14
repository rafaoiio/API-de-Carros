package br.com.RafaG.apidecarros.carros.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Carros {
    @Id
    @GeneratedValue(generator = "UUID")


    String id;
    String marca;
    String modelo;

    int ano_de_fabricacao;
    int ano_do_modelo;
    
    String placa;
    String documento_do_proprietario;
    String cor;
    String chassi;
}
