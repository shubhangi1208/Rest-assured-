package com.bridgelabz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestDemo {

    @Test
    public void getTest_Posts() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        response.prettyPrint();
        //System.out.println("Status code: " + response.prettyPrint());

        //System.out.println("Response body: " + response.prettyPrint());
        //Assert.assertEquals(response.statusCode(), 200);

        //Response responseid = RestAssured.get("https://reqres.in/api/users?page=2");
        // RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("total",equalTo(12));
        // RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().body("data.email[0]",equalTo("michael.lawson@reqres.in"));
        //Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        //Assert.assertEquals(response.statusCode(), 200);

    }

    @Test
    public void postTest_Posts() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "11");
        jsonObject.put("title", "Bridgelabz QA Learning");
        jsonObject.put("author", "Shubh");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void putTest_Posts() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "11");
        jsonObject.put("title", "Bridgelabz QA Learning");
        jsonObject.put("author", "Sachin");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/11");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void deleteTest_Posts() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/10");
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getTest_Comments() {
        Response response = RestAssured.get("http://localhost:3000/comments");
        response.prettyPrint();
    }

    @Test
    public void postTest_Comments() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "3");
        jsonObject.put("body", "some good comments");
        jsonObject.put("postId", "1");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void putTest_Comments() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "3");
        jsonObject.put("body", "some best comments");
        jsonObject.put("postId", "1");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void deleteTest_Comments() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/comments/4");
        System.out.println(response.getStatusCode());

    }

    @Test
    public void getTest_Profile() {
        Response response = RestAssured.get("http://localhost:3000/profile");
        response.prettyPrint();
    }

    /* @Test
      public void postTest_Profile(){
          RequestSpecification request=RestAssured.given();
          request.header("Content-Type", "application/json");
          JSONObject jsonObject= new JSONObject();
          jsonObject.put("name", "shubhangi");
          request.body(jsonObject.toJSONString());
          Response response = request.post("http://localhost:3000/profile");
          System.out.println(response.getStatusCode());
          System.out.println(response.prettyPrint());
      }*/
    @Test
    public void putTest_Profile() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "shubha");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }

    @Test
    public void deleteTest_Profile() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/profile/shubhangi");
        System.out.println(response.getStatusCode());

    }

}
