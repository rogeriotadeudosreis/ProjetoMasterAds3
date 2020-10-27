package model;

import enumerations.EnumSituacao;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aires Ribeiro
 */
// implements Comparable para permitir ordenar no metodo recuperar com o comando Collections.sort
//Atributos
public class Continente implements Comparable<Continente> {

    private int id = 0;
    private Date datacad = null;
    private int codContinente = 0;
    private String nomeContinente = null;
    private EnumSituacao situacao = null;

    public Continente() {
    }

    public Continente(Date datacad, int codContinente, String nomeContinente, EnumSituacao situacao) {
        this.datacad = datacad;
        this.codContinente = codContinente;
        this.nomeContinente = nomeContinente;
        this.situacao = situacao;
    }
    
     public Continente(String strDados) throws Exception {
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 5) {
            throw new Exception("Falta dados na String");
        }
        id = Integer.parseInt(vetorString[0]);
        datacad = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(vetorString[1]);
        codContinente = Integer.parseInt(vetorString[2]);
        nomeContinente = vetorString[3];
        situacao = EnumSituacao.values() [Integer.parseInt(vetorString[4])];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodContinente() {
        return codContinente;
    }

    public void setCodContinente(int codContinente) {
        this.codContinente = codContinente;
    }

    public String getNomeContinente() {
        return nomeContinente;
    }

    public void setNomeContinente(String nomeContinente) {
        this.nomeContinente = nomeContinente;
    }

    public EnumSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacao situacao) {
        this.situacao = situacao;
    }

    public Date getDatacad() {
        return datacad;
    }

    public void setDatacad(Date datacad) {
        this.datacad = datacad;
    }
    
    @Override
    public String toString() {
        String dataFormatada = "dd/MM/yyyy hh:mm:ss";
        String saida = "";
        saida += id + ";";
        saida += new SimpleDateFormat(dataFormatada).format(datacad) + ";";
        saida += codContinente + ";";
        saida += nomeContinente + ";";
        saida += situacao.ordinal() + ";";
        return saida;
    }

    //Método para ordenar um ArrayList
    @Override
    public int compareTo(Continente objeto) {
        return nomeContinente.compareToIgnoreCase(objeto.getNomeContinente());    //ordena do menor para o maior
        // return objeto.getNomeContinente().compareToIgnoreCase(nomeContinente); //ordena do maior para o menor
        //return (this.codigoContinente - objeto.getCodigoContinente());                  //ordena do menor para o maior
    }
}
