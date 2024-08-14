package br.com.RafaG.apidecarros.carros.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarrosCreateRequest {
        

    @NotBlank(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser nulo")
    String id;

    String marca;
    String modelo;


    @NotBlank(message = "Ano não pode ser vazio")
    @NotNull(message = "ANO da fabricação não pode ser nulo")
    @Length(min = 1900, max = 2025, message = "CPF precisa ter 11 caracteres e ser enviado sem mascara")
    int ano_de_fabricacao;


    @NotBlank(message = "Ano do modelo não pode ser vazio")
    @NotNull(message = "ANO do modelo não pode ser nulo")
    @Length(min = 1900, max = 2025, message = "CPF precisa ter 11 caracteres e ser enviado sem mascara")
    int ano_do_modelo;


    @NotBlank(message = "Placa não pode ser vazio")
    @NotNull(message = "Placa deve ter 7 caracteres")
    @Length(min = 7, max = 7, message = "Placa precisa ter 7 caracteres e ser enviado sem mascara")
    String placa;


    @NotBlank(message = "Documento do proprietário não pode ser vazio")
    @NotNull(message = "Documento não pode ser nulo")
    @Length(min = 11, max = 14, message = "Documento precisa ter 11 ou 14 caracteres e ser enviado sem mascara")
    String documento_do_proprietario;

 
    String cor;

    @NotBlank(message = "Chassi não pode ser vazio")
    @NotNull(message = "Chassi não pode ser nulo")
    @Length(min = 17, max = 17, message = "Chassi precisa ter 11 caracteres e ser enviado sem mascara")
    String chassi;
 

}
