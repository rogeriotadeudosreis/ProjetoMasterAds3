package interfaces;

import java.util.ArrayList;
import model.Continente;

/**
 *
 * @author Aires Ribeiro
 */
public interface ICRUDContinente {

    //Descrever os metodos
    void incluir(Continente objeto) throws Exception;

    public ArrayList<Continente> recuperar() throws Exception;

    void alterar(Continente objeto) throws Exception;

    public Continente buscarPeloId(int id) throws Exception;

    void excluir(Continente objeto) throws Exception;
}
