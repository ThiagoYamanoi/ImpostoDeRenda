package model;

import java.util.ArrayList;
import java.util.List;

public class DeclaracaoCompleta extends Declaracao{

    private List<Despesa> despesas = new ArrayList<>();

    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    protected double valorImposto() {
            double renda = getGanhoTributavel() - totalDespesasDedutiveis();

            renda = Math.max(0, renda);

            double[] limites = {
                    22847.88, 33919.92, 45012.72, 55976.16
            };

            double[] aliquotas = {
                    0.075, 0.15, 0.225, 0.275
            };
            double imposto = 0;
            for (int i = limites.length - 1; i >= 0; i--) {

                double parcela = Math.max(0, renda - limites[i]);

                imposto += parcela * aliquotas[i];

                renda -= parcela;
            }
            return imposto;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public double totalDespesasDedutiveis(){

        double despesaSaude = getDespesaSaude();
        double despesasEducacao = getDespesasEducacao();

        return  Math.min(despesaSaude, DespesaSaude.DEDUCAO_MAX) + Math.min(despesasEducacao, DespesaEducacao.DEDUCAO_MAX);
    }

    public double getDespesaSaude() {
        return despesas.stream()
                .filter(d -> d instanceof DespesaSaude)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    public double getDespesasEducacao() {
        return despesas.stream()
                .filter(d -> d instanceof DespesaEducacao)
                .mapToDouble(Despesa::getValor)
                .sum();
    }

    public void adicionarDespesa(Despesa despesa){
        despesas.add(despesa);
    }

    public void removerDespesa(Despesa despesa){
        despesas.remove(despesa);
    }
}
