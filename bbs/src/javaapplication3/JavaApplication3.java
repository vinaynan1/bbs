/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import com.google.api.client.auth.oauth2.Credential;
import org.json.JSONObject;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.mybusiness.v4.MyBusiness;
import com.google.api.services.mybusiness.v4.model.ListAccountsResponse;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.List;
/**
 *
 * @author Vinay
 */
public class JavaApplication3 {
private static final String APPLICATION_NAME =
        "Google My Business API Java Quickstart";
    private static final java.io.File DATA_STORE_DIR =
        new java.io.File(System.getProperty("user.home"),
            ".store/mybusiness_sample");
    private static FileDataStoreFactory dataStoreFactory;
    private static HttpTransport httpTransport;
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();
    private static MyBusiness mybusiness;
    
    private static Credential authorize() throws Exception{
        // Creates an InputStream to hold the client ID and secret.
        InputStream secrets = JavaApplication3.class.getResourceAsStream("‪/client_secrets.json");
System.out.println(secrets);
        // Prompts the user if no credential is found.
      
        
        InputStream secrets2= JavaApplication3.class.getResourceAsStream("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
         // Uses the InputStream to create an instance of GoogleClientSecrets.
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
            new InputStreamReader(secrets2));
        if (clientSecrets.getDetails().getClientId().startsWith("Enter")
            || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
            System.out.println(
                "Enter Client ID and Secret from Google API Console "
                    + "into google-my-business-api-sample/src/main/resources/client_secrets.json");
            System.exit(1);
        }
         GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            httpTransport, JSON_FACTORY, clientSecrets,
            Collections.singleton("https://www.googleapis.com/auth/plus.business.manage"))
            .setDataStoreFactory(dataStoreFactory).build();
        // Returns the credential.
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception {
        // TODO code application logic here
        
          Credential credential = authorize();
     System.out.println("xX");
    }
    
}
