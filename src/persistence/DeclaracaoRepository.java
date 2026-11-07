package persistence;

import model.Declaracao;

import java.util.Optional;

public interface DeclaracaoRepository {
    void save(Declaracao declaracao);
    void update(Declaracao declaracao);
    void remove(int id);
    Optional<Declaracao> buscarDeclaracaoPorId(int id);
}
