package model;

public class DespesaSaude extends Despesa{
    public final static double DEDUCAO_MAX = 1500;
    private String registroConselho;


    public DespesaSaude(int id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }
}
