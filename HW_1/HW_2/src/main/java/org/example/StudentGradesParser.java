package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

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
//                result.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(subject).append(". ");
                result.append(String.format("Студент %s получил %d по предмету %s.\n", surname, grade, subject));

            }
        } catch (IOException e) {
            logger.severe("Ошибка чтения файла " + fileName + ": " + e.getMessage());
        }

        return result.toString();
    }

    public static String parseFile(String filename) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("{")) {
                    String[] tokens = line.trim().replaceAll("[{}\"]", "").split(",");
                    String surname = "", subject = "";
                    int grade = 0;
                    for (String token : tokens) {
                        String[] parts = token.trim().split(":");
                        if (parts[0].equals("фамилия")) {
                            surname = parts[1];
                        } else if (parts[0].equals("предмет")) {
                            subject = parts[1];
                        } else if (parts[0].equals("оценка")) {
                            grade = Integer.parseInt(parts[1]);
                        }
                    }
                    result.append(String.format("Студент %s получил %d по предмету %s.\n", surname, grade, subject));
                }
            }
        }
        logger.info(result.toString());
        return result.toString();
    }
}
