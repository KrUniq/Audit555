package ru.Mirea.KharitonovaKM.Theme3.task1;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import java.io.IOException;

//экземпляр Retrofit с указанием базового URL-адреса сервера и добавлением  JacksonConverterFactory, который JSON-ответ -> объекты Java
public class Main1 {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://prime.tms-studio.ru:8085/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        try {
            //GET-запрос, который возвращает результат выполнения запроса в виде объекта типа ApiResponse
            ApiResponse response = apiService.getData().execute().body();

            if (response != null && response.getArrayNumbers() != null) {

                int[] numbers = response.getArrayNumbers();


                int maxNumber = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] > maxNumber) {
                        maxNumber = numbers[i];
                    }
                }
                System.out.println("Наибольшее число: " + maxNumber);


                int minNumber = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] < minNumber) {
                        minNumber = numbers[i];
                    }
                }
                System.out.println("Наименьшее число: " + minNumber);

                // Среднее значение
                int sum = 0;
                for (int number : numbers) {
                    sum += number;
                }
                double average = (double) sum / numbers.length;
                System.out.println("Среднее значение: " + average);
            } else {
                System.out.println("Ошибка: набор чисел не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //содержит описание GET-запроса с помощью аннотации @GET и возвращает объект типа ApiResponse
    private interface ApiService {
        @GET("/")
        retrofit2.Call<ApiResponse> getData();
    }

    //содержит поле arrayNumbers для хранения массива чисел из JSON-ответа.
    private static class ApiResponse {
        private int[] arrayNumbers;

        public int[] getArrayNumbers() {
            return arrayNumbers;
        }
    }
}

