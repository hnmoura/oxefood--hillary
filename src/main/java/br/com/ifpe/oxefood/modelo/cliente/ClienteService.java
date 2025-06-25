package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;

@Service
public class ClienteService {

    
   @Autowired
   private ClienteRepository repository;

   @Transactional
   public Cliente save(Cliente cliente) {

     usuarioService.save(cliente.getUsuario());

      for (Perfil perfil : cliente.getUsuario().getRoles()) {
           perfil.setHabilitado(Boolean.TRUE);
           perfilUsuarioRepository.save(perfil);
      }


       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }
  public List<Cliente> listarTodos() {
  
        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {

        return repository.findById(id).get();
    }

}
