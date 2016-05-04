package projetobase;


import javax.persistence.Entity;
import java.io.Serializable;


@Entity

public class Aluno extends EntidadeBase implements Serializable {

    private String nome;


    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
