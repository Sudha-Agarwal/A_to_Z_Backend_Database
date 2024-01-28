package httpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class HttpClientExample {
	public static void main(String[] args) {
		String servletUrl = "http://localhost:8080/Java11Features/simpleServlet";
		
		//create an instance of HttpClient
		HttpClient httpClient = HttpClient.newHttpClient();
		
		//or
		HttpClient.Builder builder = HttpClient.newBuilder();
		builder.connectTimeout(java.time.Duration.ofSeconds(10));
		HttpClient httpClient1 = builder.build();
		
		//create a URI for servlet request
		URI uri = URI.create(servletUrl);
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(uri)
				.header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString("This is request body"))				
				.build();
		try {
			//send the request and receive the response
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			//Print the response status code and body
			System.out.println("Status Code: " + response.statusCode());
			System.out.println("Status Code: " + response.body());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
