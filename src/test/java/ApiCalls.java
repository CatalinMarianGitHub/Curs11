import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class ApiCalls {
    private String emailCreated = generateEmail();

    public void createNewUser (String uri, String loginPassword) {
        given()
                .baseUri(uri)
                .basePath("users/signup")
                .contentType("application/json")
                .body("{\n" +
                        "    \"username\": \"CatalinMorariu\",\n" +
                        "    \"name\": \"MorariuCatalin\",\n" +
                        "    \"email\": \""+emailCreated+"\",\n" +
                        "    \"password\": \""+ loginPassword + "\",\n" +
                        "    \"password_confirmation\": \"" + loginPassword + "\"\n" +
                        "}")
                .post()
                .then()
                .statusCode(200);
        System.out.println("The following user: " + emailCreated + ", has been created!");
    }

    public void createAuthor(String psw) {
        ValidatableResponse rezponse = given().baseUri("http://34.89.187.127/api/v1/authors/CatalinMorariu")
                .auth().basic(getEmailCreated(), psw)
                .contentType("application/json")
                .body("{\n" +
                        "    \"firstName\": \"Crea\",\n" +
                        "    \"lastName\": \"JON\",\n" +
                        "    \"id\": 101\n" +
                        "}")
                .post()
                .then()
                .statusCode(200);
                System.out.println(rezponse);

    }

    public void createBook(String pssw)  {
        ValidatableResponse response = given().baseUri("http://34.89.187.127/api/v1/books/CatalinMorariu")
                .auth().basic(getEmailCreated(),pssw)
                .contentType("application/json")
                .body("{\"name\": \"CatalinBookIJ\",\"total\": \"101\",\"available\": \"91\",\"authors\": \"506\",\"id\": 200}")
                .post()
                .then()
                .statusCode(201);
            System.out.println(response);
    }


    private String generateEmail() {
        return new Random().nextInt(99999) + "@acadtest.com";
    }
    public String getEmailCreated(){
        return emailCreated;
    }
}
