package service;

import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    DeclaracaoRepository repository;

    public ExcluirSimulacaoService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public void excluir(){
        if(repository.buscarDeclaracaoPorId(1).isEmpty()){
            throw  new NoSuchElementException("nenhuma simulação encontrada");
        }
        repository.remove(1);
        repository.remove(2);
    }
}
