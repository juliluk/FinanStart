package fiapfinanstart.repository.impl;

import fiapfinanstart.entities.CartaoCredito;
import fiapfinanstart.repository.ICartaoCredito;

public class CartaoCreditoImpl implements ICartaoCredito {
    @Override
    public Boolean validar(Double valorCartao, CartaoCredito cartaoCredito) {
        if(valorCartao > cartaoCredito.getLimite()){
            return false;
        }
        return true;
    }

    @Override
    public CartaoCredito atualizar(Double valorCartao, CartaoCredito cartaoCredito) {
        if (this.validar(valorCartao, cartaoCredito )) {
            cartaoCredito.setLimite(cartaoCredito.getLimite() - valorCartao);
        }
        return cartaoCredito;
    }
}
