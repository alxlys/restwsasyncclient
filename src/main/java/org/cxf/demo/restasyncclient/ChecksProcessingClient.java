package org.cxf.demo.restasyncclient;

import org.cxf.demo.restasyncclient.model.ChecksList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author olysenko
 */
public class ChecksProcessingClient {

   public static void main(String[] args) {

      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(
            "http://localhost:8080/restwsasync/services/checksprocessingservice/checks");

      AsyncInvoker asyncInvoker = target.request().async();
      Future<Boolean> future = asyncInvoker
            .post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML_TYPE), Boolean.class);

      try {
         System.out.println(future.get());
      } catch (InterruptedException e) {
         e.printStackTrace();
      } catch (ExecutionException e) {
         if (e.getCause() instanceof BadRequestException) {
            System.out.println("BadRequestException caught.");
         }
         e.printStackTrace();
      }


   }

}
