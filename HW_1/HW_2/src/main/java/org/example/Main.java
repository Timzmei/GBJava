package org.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * Задача.1
         * Дана json строка
         * {
         *  {
         *      "фамилия":"Иванов",
         *      "оценка":"5",
         *      "предмет":"Математика"
         *  },
         *  {
         *      "фамилия":"Петрова",
         *      "оценка":"4",
         *      "предмет":"Информатика"
         *  },
         *  {
         *      "фамилия":"Краснов",
         *      "оценка":"5",
         *      "предмет":"Физика"
         *  }
         * }
         * Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
         * Студент Иванов получил 5 по предмету Математика. Студент Петрова получил 4 по предмету Информатика.
         * Студент Краснов получил 5 по предмету Физика. Используйте StringBuilder для подготовки ответа
         */

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.ALL);

        FileHandler handler = new FileHandler("org/example/logs/app.log");
        handler.setLevel(Level.ALL);

        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);

        logger.addHandler(handler);

        String resultGson = StudentGradesParser.parseFileGson("grades.json");
        String result = StudentGradesParser.parseFile("grades.json");

        logger.info(resultGson);
        logger.info(result);

    }
}