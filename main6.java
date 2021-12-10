import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.StandardSocketOptions;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class main {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        String key="task6";
        //task1
        var res1=SendRequest("{'name': 'Bruce Springsteen', 'nationality': 'BEL', 'Age': 228 ,'Salary': 322.228 }",key,requestType.PUT);
        System.out.println(res1);
        //task 2 and 3
        var res2=SendRequest("Whatever",key,requestType.GET);
        System.out.println(res2);
        //task 4
        var res3=SendRequest("{'name': 'Artsiom is the Best', 'nationality': 'BEL', 'Age': 228 ,'Salary': Noone pays in gamedev this much }",key,requestType.PUT);
        System.out.println(res3);
        //task 5 and 6
        var res4=SendRequest("Whatever",key,requestType.GET);
        System.out.println(res4);
        //task 7
        var res5=SendRequest("Whatever",key,requestType.DELETE);
        System.out.println(res5);
        var res6=SendRequest("Whatever",key,requestType.GET);
        System.out.println(res6);
        System.exit(-1);
//
    }

    private static String SendRequest(String params,String key,requestType type) {
        var urlParameters=params;
        System.setProperty("jdk.httpclient.allowRestrictedHeaders", "Content-Length");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = BuildRequest(urlParameters,key,type);
        try{
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (Exception e){
            e.printStackTrace();
        }
      return null;


    }

    private static HttpRequest BuildRequest(String urlParameters,String key,requestType type) {

        switch (type){
            case PUT ->{ return HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8098/buckets/s16550/keys/"+key))
                    .header("Content-Type","application/json")
                    .header("Accept-Encoding", "UTF-8")
                    .header("Content-Language", "en-US")
                    .header("Content-Length",Integer.toString(urlParameters.getBytes().length))
                    .PUT(HttpRequest.BodyPublishers.ofString(urlParameters))
                    .build();}
            case POST -> {
                return HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8098/buckets/s16550/keys/"+key))
                        .header("Content-Type","application/json")
                        .header("Accept-Encoding", "UTF-8")
                        .header("Content-Language", "en-US")
                        .header("Content-Length",Integer.toString(urlParameters.getBytes().length))
                        .POST(HttpRequest.BodyPublishers.ofString(urlParameters))
                        .build();
            }
            case DELETE -> {return HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8098/buckets/s16550/keys/"+key))
                    .header("Content-Type","application/json")
                    .header("Accept-Encoding", "UTF-8")
                    .header("Content-Language", "en-US")
                    .header("Content-Length",Integer.toString(urlParameters.getBytes().length))
                    .DELETE()
                    .build();}
            case GET -> {
                return HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8098/buckets/s16550/keys/"+key))
                        .header("Content-Type","application/json")
                        .header("Accept-Encoding", "UTF-8")
                        .header("Content-Language", "en-US")
                        .header("Content-Length",Integer.toString(urlParameters.getBytes().length))
                        .GET()
                        .build();
            }

        }

        return null;
    }


}

enum requestType{
    PUT,POST,GET,DELETE
}

