
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import projetobase.Aluno;
import projetobase.AlunoRepository;

import java.util.List;


@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class AlunoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private AlunoRepository alunoRepository;
    private Aluno aluno;
    private Aluno aluno1;
    private Aluno aluno2;
    private Aluno aluno3;
    private List<Aluno> listaDeAlunos;

    @Before
    public void init(){
        aluno1 = new Aluno("ProjetoBase 1");
        alunoRepository.salvar(aluno1);

        aluno2 = new Aluno("ProjetoBase 2");
        alunoRepository.salvar(aluno2);

        aluno3 = new Aluno("ProjetoBase 3");
        alunoRepository.salvar(aluno3);
    }

    @Test
    public void deve_salvar_um_aluno() {
        Integer idEsperado = 7;
        aluno = new Aluno("ProjetoBase");

        alunoRepository.salvar(aluno);

        assertEquals(idEsperado, aluno.getId());
    }

    @Test
    public void deve_buscar_todos_os_alunos(){
        int quantidadeDeAlunosEsperado = 3;

        listaDeAlunos = alunoRepository.buscarTodos();

        assertEquals(quantidadeDeAlunosEsperado,listaDeAlunos.size());
    }

    @Test
    public void deve_alterar_um_aluno(){
        Integer idAlunoEsperado = 3;
        listaDeAlunos = alunoRepository.buscarTodos();
        int ultimoAluno = listaDeAlunos.size() -1;
        aluno = listaDeAlunos.get(ultimoAluno);
        aluno.setNome("ProjetoBase 3 - Alterado");

        alunoRepository.salvar(aluno);

        listaDeAlunos = alunoRepository.buscarTodos();
        ultimoAluno = listaDeAlunos.size() -1;
        aluno = listaDeAlunos.get(ultimoAluno);

        assertEquals(idAlunoEsperado,aluno.getId());

    }
}
