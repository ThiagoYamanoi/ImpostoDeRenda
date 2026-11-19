package service;

import exception.EntityAlreadyExists;
import model.DeclaracaoCompleta;
import model.DeclaracaoSimplificada;
import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

import java.util.List;
import java.util.Optional;

//TODO clean code: atenção para o espaçamento vertical. Veja o que alterei.
public class NovaSimulacaoService {
    private final DeclaracaoRepository repository;

    public NovaSimulacaoService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public void iniciar(double ganhoTributavel, double valorJaPago){
        if(repository.buscarDeclaracaoPorId(1).isPresent()){
            throw  new EntityAlreadyExists("simulacao ja existe em execução");
        }
        DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(1, ganhoTributavel, valorJaPago);
        DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(2, ganhoTributavel, valorJaPago);

        repository.save(declaracaoCompleta);
        repository.save(declaracaoSimplificada);
    }
}
