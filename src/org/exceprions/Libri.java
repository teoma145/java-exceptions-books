package org.exceprions;

public class Libri {
    private String nome;
    private int pagine;
    private String autore;
    private String editore;
    public Libri(String nome,int pagine,String autore,String editore)throws IllegalArgumentException{
        if (nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("campo nome vuoto");
        }
        if (pagine <= 0){
            throw new IllegalArgumentException("deve avere almeno una pagina");
        }
        if (autore == null || autore.isEmpty()){
            throw new IllegalArgumentException("campo autore vuoto");
        }
        if (editore == null || editore.isEmpty()){
            throw new IllegalArgumentException("campo editore vuoto");
        }
        this.nome= nome;
        this.pagine=pagine;
        this.autore = autore;
        this.editore = editore;

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome)throws IllegalArgumentException {
        if(nome==null || nome.isEmpty()){
            throw new IllegalArgumentException("nome vuoto");
        }
        this.nome=nome;
    }
    public int getPages() {
        return pagine;
    }
    public void setPagine(int pagine) {
        if(pagine < 0){
            throw new IllegalArgumentException("nome vuoto");
        }
        this.pagine=pagine;
    }
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        if(autore==null || autore.isEmpty()){
            throw new IllegalArgumentException("autore vuoto");
        }
        this.autore=autore;
    }
    public String getEditore() {
        return editore;
    }
    public void setEditore(String editore) {
        if(editore==null || editore.isEmpty()){
            throw new IllegalArgumentException("editore vuoto");
        }
        this.editore=editore;
    }
}
