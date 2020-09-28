package persistencias;

import modelos.Continente;
import interfaces.ICRUDContinente;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import enumeradores.EnumArquivosTXT;
import utilidades.GeradorIdentificador;

public class ContinentePersistencia implements ICRUDContinente {

    Enum nomeDoArquivo = EnumArquivosTXT.CONTINENTE;

    public ContinentePersistencia(Enum nomeArquivo) {
        this.nomeDoArquivo = nomeArquivo;
    }

    @Override
    public void incluir(Continente objeto) throws Exception {
        verificarArquivo();
        try {
            GeradorIdentificador idCont = new GeradorIdentificador();
            objeto.setId(idCont.getID());
            //Criar o Arquivo
            FileWriter fw = new FileWriter(nomeDoArquivo + ".txt", true);
            //Criar o Buffer do Arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no Arquivo
            bw.write(objeto.toString() + "\n");
            //fecha o arquivo
            bw.close();
            idCont.finalize();
        } catch (Exception erro) {
            throw new Exception("Erro ao grvar registro de continente\nVerifique !", erro);
        }
    }

    @Override
    public ArrayList<Continente> recuperar() throws Exception {
        try {
            ArrayList<Continente> Lista = new ArrayList<Continente>();
            FileReader fr = new FileReader(nomeDoArquivo + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Continente objetoContinente = new Continente(linha);
                Lista.add(objetoContinente);
            }
            br.close();
            Collections.sort(Lista);
            return Lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao buscar dados da tabela de continentes\nVerifique !" + erro);
        }
    }

    @Override
    public void alterar(Continente objetoNovo) throws Exception {
        try {
            ArrayList<Continente> ListaDeContinente = recuperar();
            FileWriter fw = new FileWriter(nomeDoArquivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < ListaDeContinente.size(); pos++) {
                Continente aux = ListaDeContinente.get(pos);
                if (aux.getId() == objetoNovo.getId()) {
                    bw.write(objetoNovo.toString() + "\n");
                } else {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw new Exception("Erro ao alterar este registro.\n\nVerifique !", erro);
        }
    }
    
     public Continente buscarPeloId(int id) throws Exception {
       
        try {

            FileReader fr = new FileReader(nomeDoArquivo + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Continente objetoContinente = new Continente(linha);
                if (objetoContinente.getId() == id) {
                    br.close();
                    return objetoContinente;
                }
            }
            br.close();

            return null;
        } catch (Exception erro) {
            throw new Exception("Id do Continente não encontrado\nVerifique !" + erro.getMessage());
        }
    }
    
    @Override
    public void excluir(Continente objeto) throws Exception {
        try {
            ArrayList<Continente> lista = recuperar();
            FileWriter fw = new FileWriter(nomeDoArquivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < lista.size(); pos++) {
                Continente aux = new Continente();
                aux = lista.get(pos);
                if (!objeto.getNomeContinente().equalsIgnoreCase(aux.getNomeContinente())) {
                    bw.write(aux.toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void verificarArquivo() throws IOException {
        File arquivo = new File(nomeDoArquivo + ".txt");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

}
