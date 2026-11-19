package model;

import java.util.Objects;

//TODO organize a classe pela ordem que coloquei - dica de clean code.
public abstract class Declaracao {
    private final int id;
    private final double ganhoTributavel;
    private final double valorJaPago;

    //TODO construtores
    public Declaracao(int id, double ganhoTributavel, double valorJaPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorJaPago = valorJaPago;
    }

    //TODO métodos que você define e/ou implementa
    public final double valorAPagar(){
        return valorImposto() - valorJaPago;
    }

    protected abstract double valorImposto();

    //TODO métodos gerados pelo IDE, mas com lógica, antes dos setters
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("id: %d | GanhoTributavel: %f | ValorPago: %f | Valor a pagar: %f\n"
                , id, ganhoTributavel, valorJaPago, valorAPagar());
    }

    //TODO getters e setters no final da classe
    public int getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorJaPago() {
        return valorJaPago;
    }

}
