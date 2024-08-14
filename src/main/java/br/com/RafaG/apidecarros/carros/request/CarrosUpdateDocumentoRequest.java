package br.com.RafaG.apidecarros.carros.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarrosUpdateDocumentoRequest {
    

    @NotBlank(message = "Documento não pode ser vazio")
    @NotNull(message = "Documento não pode ser nulo")
    String Documento_do_proprietario;
}
