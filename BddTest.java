package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.simple.JSONObject;

public class BddTest {
    @Test
    public void get_BddTest_Posts() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/posts").
                then().
                statusCode(200);
    }

    @Test
    public void post_BDDTest_Posts() {

        //  http://localhost:3000/posts/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 6);
        jsonObject.put("title", "json-server");
        jsonObject.put("author", "Sachin");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().post("http://localhost:3000/posts/").then().statusCode(201);
    }

    @Test
    public void put_BDDTest_Posts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "json-server");
        jsonObject.put("author", "John");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/posts/5").then().statusCode(200);

    }

    @Test()
    public void delete_BDDTest_Posts() {

        given().
                header("Content-Type", "application/json").
                when().delete("http://localhost:3000/posts/5").then().statusCode(200);

    }

    @Test
    public void get_BddTest_Comments() {
        Response response = RestAssured.get("http://localhost:3000/comments");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/comments").
                then().
                statusCode(200);
    }

    @Test
    public void post_BDDTest_Comments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "5");
        jsonObject.put("body", "some positive comments");
        jsonObject.put("postId", "1");
        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().post(" http://localhost:3000/comments").then().statusCode(201);
    }

    @Test
    public void put_BDDTest_Comments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "5");
        jsonObject.put("body", "some negative comments");
        jsonObject.put("postId", "1");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/comments/5").then().statusCode(200);

    }

    @Test()
    public void delete_BDDTest_Comments() {

        given().
                header("Content-Type", "application/json").
                when().delete("http://localhost:3000/comments/5").then().statusCode(200);
    }
    @Test
    public void get_BddTest_Profile() {
        Response response = RestAssured.get("http://localhost:3000/profile");
        response.prettyPrint();
        given().
                when().
                get("http://localhost:3000/profile").
                then().
                statusCode(200);
    }
    @Test
    public void put_BDDTest_Profile() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "shubhangi Amilkanthwar");


        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/profile").then().statusCode(200);

    }
}
