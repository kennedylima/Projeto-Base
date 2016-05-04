package projetobase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/alunos")
@Produces("application/json")
@Consumes("application/json")
public class AlunoRest  {

    @Autowired
    private  AlunoService alunoService;

    @POST
    public Response salvar(Aluno aluno){
        System.out.println(aluno.getNome());
        alunoService.salvar(aluno);
        return Response.status(200).entity(aluno.getId()).build();
    }
}
