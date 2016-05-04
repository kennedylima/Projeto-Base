import org.junit.Test;
import projetobase.Aluno;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.given;

public class AlunoRestTest {

    @Test
    public void deve_salvar_um_aluno(){
        Aluno aluno = new Aluno("ProjetoBase - Rest");
        given().
                contentType(MediaType.APPLICATION_JSON).
                body(aluno).
                post("http://localhost:8080/ProjetoBase/ws/alunos").
                then()
                .statusCode(200);
    }
}
