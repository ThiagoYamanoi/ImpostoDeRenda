package model;

public class DespesaSaude extends Despesa{
    public final static double DEDUCAO_MAX = 1500;
    private final String registroConselho;


    public DespesaSaude(int id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    //TODO sem getter para o registroConselho, a variável não ta sendo usada para nada (nem em toString)

}
