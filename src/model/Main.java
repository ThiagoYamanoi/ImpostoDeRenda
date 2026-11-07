package model;

import persistence.DeclaracaoRepository;
import persistence.DeclaracaoRepositoryImpl;
import service.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DeclaracaoRepositoryImpl repository = new DeclaracaoRepositoryImpl();
        NovaSimulacaoService simulacaoService = new NovaSimulacaoService(repository);
        AdicionarDespesaService adicionarDespesaService = new AdicionarDespesaService(repository);
        ExcluirSimulacaoService excluirSimulacaoService = new ExcluirSimulacaoService(repository);

        simulacaoService.iniciar(100000, 10000);
        adicionarDespesaService.adicionar(1, "hospital1", 120, "123211", "seila", TipoDespesa.SAUDE);

        adicionarDespesaService.adicionar(2, "hospital2", 120, "123211", "seila", TipoDespesa.SAUDE);

        adicionarDespesaService.adicionar(3, "hospital3", 120, "123211", "seila", TipoDespesa.SAUDE);

        adicionarDespesaService.adicionar(4, "hospital4", 120, "123211", "seila", TipoDespesa.SAUDE);

        adicionarDespesaService.adicionar(5, "hospital5", 120, "123211", "seila", TipoDespesa.SAUDE);

        adicionarDespesaService.adicionar(6, "escola1", 120, "123211", "seila", TipoDespesa.EDUCACAO);

        adicionarDespesaService.adicionar(7, "escola2", 120, "123211", "seila", TipoDespesa.EDUCACAO);

        adicionarDespesaService.adicionar(8, "escola3", 120, "123211", "seila", TipoDespesa.EDUCACAO);

        adicionarDespesaService.adicionar(9, "escola4", 120, "123211", "seila", TipoDespesa.EDUCACAO);

        adicionarDespesaService.adicionar(10, "escola5", 120, "123211", "seila", TipoDespesa.EDUCACAO);


        RelatorioSimulacaoService relatorioSimulacaoService = new RelatorioSimulacaoService(repository);

        String relatorio = relatorioSimulacaoService.criarRelatorio();

        System.out.println(relatorio);
        excluirSimulacaoService.excluir();

        simulacaoService.iniciar(200_000, 20000);
        System.out.println(relatorioSimulacaoService.criarRelatorio());


    }
    }
