package fiapfinanstart.entities;

import fiapfinanstart.util.RandomUuidCreator;
import java.util.UUID;

public class Categoria {
    private UUID idCategoria;
    private String dsCategoria;

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }

    public void setDsCategoria(String dsCategoria) {
        this.dsCategoria = dsCategoria;
    }

    public Categoria(UUID idCategoria, String dsCategoria) {
        this.idCategoria = RandomUuidCreator.getRandomUuid();;
        this.dsCategoria = dsCategoria;
    }
}
