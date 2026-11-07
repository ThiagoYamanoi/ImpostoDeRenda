package persistence;

import model.Declaracao;
import service.AdicionarDespesaService;
import service.NovaSimulacaoService;

import java.util.*;

public class DeclaracaoRepositoryImpl implements DeclaracaoRepository {

    private static final Map<Integer, Declaracao> repository = new HashMap<>();

    @Override
    public void save(Declaracao declaracao) {
        repository.put(declaracao.getId(), declaracao);
    }


    @Override
    public void update(Declaracao declaracao) {
        repository.replace(declaracao.getId(), declaracao);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }


    @Override
    public Optional<Declaracao> buscarDeclaracaoPorId(int id) {
        return Optional.ofNullable(repository.get(id));
    }

}
