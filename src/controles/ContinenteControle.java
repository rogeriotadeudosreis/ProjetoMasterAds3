package controles;

import java.util.ArrayList;
import modelos.Continente;
import interfaces.ICRUDContinente;
import persistencias.ContinentePersistencia;
import enumeradores.EnumArquivosTXT;

public class ContinenteControle implements ICRUDContinente {

    private ICRUDContinente objeto = null;

    public ContinenteControle() {
        objeto = new ContinentePersistencia(EnumArquivosTXT.CONTINENTE);
    }

    @Override
    public void incluir(Continente objeto) throws Exception {
        this.objeto.incluir(objeto);
    }

    @Override
    public ArrayList<Continente> recuperar() throws Exception {
        return this.objeto.recuperar();
    }

    @Override
    public void alterar(Continente objeto) throws Exception {
        this.objeto.alterar(objeto);
    }

    public Continente buscarPeloId(int id) throws Exception {
        return this.objeto.buscarPeloId(id);
    }
    
    @Override
    public void excluir(Continente Objeto) throws Exception {
        this.objeto.excluir(Objeto);
    }

}
