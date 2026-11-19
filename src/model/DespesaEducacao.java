package model;

public class DespesaEducacao extends Despesa{
    public final static double DEDUCAO_MAX = 2000;
    private final String nomeInstituicao;


    public DespesaEducacao(int id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    //TODO sem getter para o nomeInstituicao, a variável não ta sendo usada para nada (nem em toString)
}

