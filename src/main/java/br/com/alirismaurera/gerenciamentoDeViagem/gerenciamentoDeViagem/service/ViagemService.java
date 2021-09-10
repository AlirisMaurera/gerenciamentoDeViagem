package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.service;

import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities.Clientes;
import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.repository.ClientesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ViagemService {

    @Autowired
    private ClientesRepository clientesRepository;


    public Iterable<Clientes> listar(){

        return clientesRepository.findAll();
    }


    public Clientes salvar(Clientes clientes) {
         return clientesRepository.save(clientes);
    }

    public Optional<Clientes> buscarPorId(Long id){
        Optional<Clientes> cliente = verificarSeExiste(id);
        return cliente;
    }

    public Optional<Clientes> deletar(Long id){
        Optional<Clientes> clientes = verificarSeExiste(id);
        if(clientes.isPresent()){ clientesRepository.delete(clientes.get());
                                    }
        return clientes;
    }

    public Clientes atualizarCliente(long id, Clientes cliente) {
        verificarSeExiste(id);
        return clientesRepository.save(cliente);

    }

    public Optional<Clientes> verificarSeExiste(Long id){
        Optional<Clientes> cliente = clientesRepository.findById(id);
        if(cliente == null){
            return null;
        } return cliente;
    }


}
