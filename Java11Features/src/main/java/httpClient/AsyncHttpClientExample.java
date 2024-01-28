package httpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncHttpClientExample {
	public static void main(String[] args) {
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		URI ur1 = URI.create("http://localhost:8080/Java11Features/simpleServlet");
		URI ur2 = URI.create("http://localhost:8080/Java11Features/simpleServlet1");
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(ur1)
					
				.build();
		
		HttpRequest request1 = HttpRequest.newBuilder()
				.uri(ur2)
					
				.build();
		
		//send the request asynchronously and handle response
		CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		CompletableFuture<HttpResponse<String>> futureResponse1 = httpClient.sendAsync(request1, HttpResponse.BodyHandlers.ofString());
		
		//Define the callback to be executed when the response is received
		futureResponse.thenAccept(response -> {
			System.out.println("Status: " + response.statusCode());
			System.out.println("Response Body: " + response.body());
		});
		
		//for concurrent
		CompletableFuture<Void> allOf = CompletableFuture.allOf(futureResponse,futureResponse1);
		
		try {
			allOf.get();
			HttpResponse<String> response = futureResponse.get();
			HttpResponse<String> response1 =futureResponse1.get();
			
			System.out.println(response.body());
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//futureResponse.join();
	}

}
