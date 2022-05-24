package com.bridgelabz;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TwiterRestaurred {
    @Test
    //API key","API secret","Acesstoken","Access secret
    public void twiterPost() {
        Response response = RestAssured.given()
                .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                        "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                        "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                        "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                .post("https://api.twitter.com/1.1/statuses/update.json?status= Good morning");
        System.out.println(response.prettyPrint());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID:" + jsonPath.get("id_str"));

    }

    @Test
    public void retwitPost() {
        Response response = RestAssured.given()
                .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                        "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                        "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                        "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                .post("https://api.twitter.com/1.1/statuses/retweet/1528376011506974721.json");
        System.out.println(response.prettyPrint());

    }
    @Test
    public void Deletetweet() {
        Response response = RestAssured.given()
                .auth().oauth("S3eDYwiSJ57HQPWliHxhnndgY",
                        "4Nd9zhlvUiVJO9ibxbRg041s6lhDFujCEP7WwIeBZ8BwA2OTnP",
                        "1527487364817616896-tYi7SPwKbbGyMMYFS1AKjMSTVkUjsk",
                        "YNjoCEWnq08coZnq4p4dafpGEzOm0efeHdkp5q8jRPfhu")
                .delete("https://api.twitter.com/2/tweets/1528570256851365890");
        System.out.println(response.prettyPrint());

    }

}
