package service;

import model.*;
import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

public class AdicionarDespesaService {

    DeclaracaoRepository repository;

    public AdicionarDespesaService(DeclaracaoRepository repository) {

        this.repository = repository;
    }

    public void adicionar(int id, String descricao, double valor, String cnpj, String stringClasse, TipoDespesa tipo){
        if(repository.buscarDeclaracaoPorId(1).isEmpty()){
            throw  new IllegalStateException("simulação não inicada");
        }

        DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repository.buscarDeclaracaoPorId(1).get();

        if(tipo == TipoDespesa.EDUCACAO){
            DespesaEducacao despesa = new DespesaEducacao(id, descricao, valor, cnpj, stringClasse);
            declaracao.adicionarDespesa(despesa);
        }
        else if(tipo == TipoDespesa.SAUDE){
            DespesaSaude despesa = new DespesaSaude(id, descricao, valor, cnpj, stringClasse);
            declaracao.adicionarDespesa(despesa);
        }


    }
}
