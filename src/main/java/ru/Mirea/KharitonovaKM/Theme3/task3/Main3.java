package ru.Mirea.KharitonovaKM.Theme3.task3;

import com.fasterxml.jackson.annotation.JsonProperty;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import java.io.FileWriter;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        // Создание экземпляра Retrofit с указанием базового URL-адреса сервера и добавлением JacksonConverterFactory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://prime.tms-studio.ru:8085")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Создание объекта PrimeRequest
        int[] numbers = {1, 2, 3, 4, 5};
        PrimeRequest primeRequest = new PrimeRequest(numbers);

        // Отправка POST-запроса
        Call<PrimeResponse> call = apiService.sendData(primeRequest);
        try {
            PrimeResponse response = call.execute().body();
            if (response != null) {
                System.out.println("Ответ сервера: " + response.getAnswer());

                // Сохранение ответа в файл
                try (FileWriter fileWriter = new FileWriter("response.json")) {
                    fileWriter.write(response.getAnswer());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ответ от сервера пустой.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Определение интерфейса сервиса API
    private interface ApiService {
        @POST("/")
        Call<PrimeResponse> sendData(@Body PrimeRequest request);
    }

    // Определение класса PrimeRequest
    private static class PrimeRequest {
        @JsonProperty("numbers")
        private int[] numbers;

        public PrimeRequest(int[] numbers) {
            this.numbers = numbers;
        }
    }
    // Определение класса PrimeResponse
    private static class PrimeResponse {
        @JsonProperty("answer")
        private String answer;

        public String getAnswer() {
            return answer;
        }
    }
}