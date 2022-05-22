package SpecBuilders;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

public class specBuilders {
    RequestSpecification reqSpec;
    ResponseSpecification respSpec;
    public RequestSpecification GetSpecBuilder(){
        reqSpec=new RequestSpecBuilder().setBaseUri(RestAssured.baseURI="https://reqres.in/").setContentType(ContentType.JSON).build();
        return reqSpec;
    }

    public ResponseSpecification RespSpecBuilder(File schemaPath){
        respSpec=new ResponseSpecBuilder().expectStatusCode(200).setDefaultParser(Parser.JSON).expectBody(JsonSchemaValidator.matchesJsonSchema(schemaPath)).build();
        return respSpec;
    }
}
