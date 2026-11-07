package service;

import model.*;
import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;

import java.util.List;

public class RelatorioSimulacaoService {
    DeclaracaoRepository repository;

    public RelatorioSimulacaoService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public String criarRelatorio() {
        StringBuilder builder = new StringBuilder();
        if (repository.buscarDeclaracaoPorId(1).isPresent()) {

            builder.append(repository.buscarDeclaracaoPorId(2).get().toString());
            DeclaracaoCompleta declaracao = (DeclaracaoCompleta) repository.buscarDeclaracaoPorId(1).get();

            builder.append(relatorioDespesas(declaracao));

        }
        return builder.toString();
    }

    private String relatorioDespesas(DeclaracaoCompleta declaracaoCompleta){

        StringBuilder builder = new StringBuilder();
        builder.append(declaracaoCompleta.toString());
        builder.append("despesas saúde- valor total: ");
        builder.append(declaracaoCompleta.getDespesaSaude());
        builder.append("\n");

        declaracaoCompleta.getDespesas()
                .stream()
                .filter(s -> s instanceof DespesaSaude)
                .forEach(builder::append);


        builder.append("\n");
        builder.append("despesas educação - valor total: ");
        builder.append(declaracaoCompleta.getDespesasEducacao());
        builder.append("\n");

        declaracaoCompleta.getDespesas()
                .stream()
                .filter(s -> s instanceof DespesaEducacao)
                .forEach(builder::append);

        return  builder.toString();
    }



}

