package projetobase;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AlunoDAO implements AlunoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AlunoDAO() {
    }

    public AlunoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public void salvar(Aluno aluno) {
        entityManager.persist(aluno);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aluno> buscarTodos() {
        return entityManager
                .createQuery("FROM Aluno a")
                .getResultList();
    }
}
