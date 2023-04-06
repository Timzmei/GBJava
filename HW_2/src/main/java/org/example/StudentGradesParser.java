package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StudentGradesParser {
    private static final Logger logger = Logger.getLogger(StudentGradesParser.class.getName());

    public static String parseFileGson(String fileName) {
        StringBuilder result = new StringBuilder();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(fileName)) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                String surname = jsonObject.get("фамилия").getAsString();
                String grade = jsonObject.get("оценка").getAsString();
                String subject = jsonObject.get("предмет").getAsString();
                result.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(subject).append(". ");

            }
        } catch (IOException e) {
            logger.severe("Ошибка чтения файла " + fileName + ": " + e.getMessage());
        }
//        logger.info(result.toString());
        return result.toString();
    }

    public static String parseFile(String filename) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            ArrayList<String> list = new ArrayList<>();
            try {
                File file = new File(filename);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                    list.add(line);
                }

                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String stringJson = list.stream().map(Object::toString).collect(Collectors.joining(""));

            String[] tokens = stringJson.trim().replaceAll("[\\[\"\\]{}]", "").split(",");
            LinkedList<String> surname = new LinkedList<>();
            LinkedList<String> subject = new LinkedList<>();
            LinkedList<Integer> grade = new LinkedList<>();
            for (String token : tokens) {
                String[] parts = token.trim().split(":");
                if (parts[0].equals("фамилия")) {
                    surname.add(parts[1]);
                } else if (parts[0].equals("предмет")) {
                    subject.add(parts[1]);
                } else if (parts[0].equals("оценка")) {
                    grade.add(Integer.parseInt(parts[1]));
                }

            }
            for (int i = 0; i < surname.size(); i ++) {
                result.append(String.format("Студент %s получил %d по предмету %s.\n", surname.get(i), grade.get(i), subject.get(i)));
            }
        }
        return result.toString();
    }
}
