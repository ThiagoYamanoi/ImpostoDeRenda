package model;

public class DeclaracaoSimplificada extends Declaracao {

    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    protected double valorImposto() {
        if(getGanhoTributavel() <= 22_847.88){
            return 0;
        }
        return (getGanhoTributavel() - 22_847.88) * 0.2;
    }
}
