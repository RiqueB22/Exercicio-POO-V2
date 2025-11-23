package org.exercicio.POO.Transacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trasancao {
    private LocalDateTime data;
    private TipoTransancao tipo;
    private double valor;

    public Trasancao(TipoTransancao tipo, double valor) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return getTipo() == TipoTransancao.DEPOSITO?"Transação: " + getTipo() + " - R$ " + getValor() + " - Data: " + getData().format(formato):
                "Trasanção: " + getTipo() + " - R$ -" + getValor() + " - Data: " + getData().format(formato);
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransancao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransancao tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
