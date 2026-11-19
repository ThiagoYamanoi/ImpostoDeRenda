package service;

import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private final DeclaracaoRepository repository; //todo não esqueça de private e final só porque está no service

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
