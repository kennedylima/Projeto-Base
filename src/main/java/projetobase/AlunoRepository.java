package projetobase;

import java.util.List;

public interface AlunoRepository  {
    void salvar(Aluno aluno);
    List<Aluno> buscarTodos();
}
