package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpfAndNome(String nome, String cpf);

    List<Cliente> consultarPorCpf(String cpf);

    List<Cliente> consultarPorNome(String nome);
    
    
}