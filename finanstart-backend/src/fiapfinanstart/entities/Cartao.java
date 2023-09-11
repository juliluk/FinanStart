package fiapfinanstart.entities;

import java.time.LocalDate;

public class Cartao extends Transacao{
    public Cartao(String descricao, Double vlTransacao, LocalDate dtTransacao) {
        super(descricao, vlTransacao, dtTransacao);

    }
}
