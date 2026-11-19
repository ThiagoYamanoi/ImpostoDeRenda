package service;

import model.*;
import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

public class AdicionarDespesaService {

    private final  DeclaracaoRepository repository;

    public AdicionarDespesaService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public void adicionar(int id, String descricao, double valor, String cnpj, String stringClasse, TipoDespesa tipo){
        /*if(repository.buscarDeclaracaoPorId(1).isEmpty()){
            throw  new IllegalStateException("simulação não inicada");
        }

        DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repository.buscarDeclaracaoPorId(1).get();*/

        //TODO mesma coisa do código comentado, mas usando a API declarativa do Optional
        DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repository
                .buscarDeclaracaoPorId(1)
                .orElseThrow(() -> new IllegalStateException("simulação não iniciada")); //TODO retorna ou lança se Optiona.empty

/*        if(tipo == TipoDespesa.EDUCACAO){
            DespesaEducacao despesa = new DespesaEducacao(id, descricao, valor, cnpj, stringClasse);
            declaracao.adicionarDespesa(despesa);
        }
        else if(tipo == TipoDespesa.SAUDE){
            DespesaSaude despesa = new DespesaSaude(id, descricao, valor, cnpj, stringClasse);
            declaracao.adicionarDespesa(despesa);
        }*/

        //TODO mesma coisa que o anterior, mas mais idiomático usando if ternário e polimorfísmo de atribuição
        Despesa despesa = (tipo == TipoDespesa.EDUCACAO)
                ? new DespesaEducacao(id, descricao, valor, cnpj, stringClasse)
                : new DespesaSaude(id, descricao, valor, cnpj, stringClasse);

        declaracao.adicionarDespesa(despesa);
    }
}
