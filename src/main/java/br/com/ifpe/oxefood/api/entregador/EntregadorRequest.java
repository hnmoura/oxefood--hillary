package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;


import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   @Column
   private String nome;

   @Column
   private String cpf;

   @Column
   private String rg;

   @Column
   private LocalDate dataNascimento;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

   @Column
   private int qtdEntregasRealizadas;

   @Column
   private double valorFrete;

   @Column
   private String enderecoRua;

   @Column
   private String enderecoCompleto;

   @Column
   private String enderecoNumero;

   @Column
   private String enderecoBairro;

   @Column
   private String enderecoCidade;

   @Column
   private String enderecoCep;

   @Column
   private String enderecoUf;

   @Column 
   private boolean ativo;

     public Entregador build() {

       return Entregador.builder()
       .nome(nome).cpf(cpf).rg(rg).dataNascimento(dataNascimento).foneCelular(foneCelular).foneFixo(foneFixo).qtdEntregasRealizadas(qtdEntregasRealizadas).valorFrete(valorFrete).enderecoRua(enderecoRua).enderecoCompleto(enderecoCompleto).enderecoNumero(enderecoNumero).enderecoBairro(enderecoBairro).enderecoCidade(enderecoCidade).enderecoCep(enderecoCep).enderecoUf(enderecoUf)
           .build();
   }

}


