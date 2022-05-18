package utils;

import utilClass.ProductModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import utilClass.SignInModel;
import utilClass.UserModel;

public class Api {

    private HttpURLConnection connection;
    private final String urlProducts = "http://192.168.1.11:3000/api/products/";
    private final String urlUsers = "http://192.168.1.11:3000/api/users/";
    private final String urlSignIn = "http://192.168.1.11:3000/api/signIn/";
    private URL url;
    private final ObjectMapper mapper = new ObjectMapper();

    public List<ProductModel> showProducts() throws MalformedURLException, IOException {
        url = new URL(this.urlProducts);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Java Client");

        try ( var responseApi = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            List<ProductModel> response = convertToMap(responseApi.readLine(), new TypeReference<List<ProductModel>>() {
            });
            return response;
        } finally {
            connection.disconnect();
        }
    }

    public List<ProductModel> createProduct(String mark, String name,
            String description, Integer price, Integer calification,
            String materials, String prodId, String referentialImage) throws MalformedURLException, IOException {
        
        url = new URL(this.urlProducts);
        String urlParameters = "mark=" + mark + "&name=" + name
                + "&description=" + description + "&price=" + price
                + "&calification=" + calification + "&materials=" + materials + "&prodId=" + prodId + "&referentialImage=" + referentialImage;

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Java Client");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        try ( var writeToApi = new DataOutputStream(connection.getOutputStream())) {
            writeToApi.write(postData);

            try ( var responseApi = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                List<ProductModel> response = convertToMap(responseApi.readLine(), new TypeReference<List<ProductModel>>() {
                });
                return response;
            }
        } finally {
            connection.disconnect();
        }
    }

    public List<SignInModel> signIn(String email, String password) throws IOException {
        String urlParametros = "email=" + email + "&password=" + password;
        byte[] postData = urlParametros.getBytes(StandardCharsets.UTF_8);

        url = new URL(this.urlSignIn);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Java Client");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        try ( var wr = new DataOutputStream(connection.getOutputStream())) {
            wr.write(postData);

            try ( var responseApi = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                List<SignInModel> response = convertToMap(responseApi.readLine(), new TypeReference<List<SignInModel>>() {
                });
                return response;
            }
        } finally {
            connection.disconnect();
        }

    }

    public List<UserModel> getUserInfo(String userId) throws IOException {
        url = new URL(this.urlUsers + userId);

        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Java Client");

        try ( var responseApi = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            List<UserModel> response = convertToMap(responseApi.readLine(), new TypeReference<List<UserModel>>() {
            });

            return response;
        } finally {
            connection.disconnect();
        }

    }

    // Otras funciones
    public <T> T convertToMap(String json, TypeReference<T> reference) {
        try {
            return this.mapper.readValue(json, reference);
        } catch (JsonProcessingException ex) {
            System.out.println("Error al convertir a objeto");
        }
        return null;
    }
}
