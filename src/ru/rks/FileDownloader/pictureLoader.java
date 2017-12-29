package ru.rks.FileDownloader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Класс для скачивания картинок
 *
 * @author Рязанов К.С.
 */
public class pictureLoader {
    private static final String PATH_TO_PICTURE = "D:\\Work\\Threads\\src\\ru\\rks\\FileDownloader\\pictures\\picture";
    private static final String OUT_FILE_TXT = "D:\\Work\\Threads\\src\\ru\\rks\\FileDownloader\\outFile.txt";
    private static final String IN_FILE_TXT = "D:\\Work\\Threads\\src\\ru\\rks\\FileDownloader\\inFileImages.txt";

    public static void main(String[] args) {
        startProgramm();
    }

    private static void startProgramm() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(IN_FILE_TXT))) {
            String link;
            while ((link = bufferedReader.readLine()) != null) {
                URL url = new URL(link);
                downloader(linksWriter(stringConvertor(url)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Записывает HTML-код страницы в мультистроку.
     * @param url -адрес страницы
     * @return мультистрока, содержащая HTML-код страницы.
     */
    private static String stringConvertor(URL url) {
        String result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            result = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * Ищет ссылки на скачивание и записывает их arrayList и в файл outFile.txt
     * @param multiString мультистрока с HTML-кодом страницы.
     * @return arrayList , содержащий ссылки на скачивание.
     */
    private static ArrayList<String> linksWriter(String multiString) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT))) {
            Pattern email_pattern = Pattern.compile("\\s*(?<=href\\s?=\\s?\")[^>]*/*((jpg)|(png)|(gif))(?=\")");
            Matcher matcher = email_pattern.matcher(multiString);

            for (int i = 0; (matcher.find() && i < 2); i++) {
                arrayList.add(matcher.group() + "\r\n");
                outFile.write(matcher.group() + "\r\n");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return arrayList;
    }

    /**
     * Метод запускает потоки на скачивание по ссылкам , содержащимся в arrayList
     * @param arrayList arrayList со ссылками на скачивание.
     */
    private static void downloader(ArrayList<String> arrayList) {
        int count = 1;
        for (String downloadLink:arrayList) {
            new FileLoader(downloadLink, PATH_TO_PICTURE + String.valueOf(count) + ". jpg").start();
            System.out.println("Загрузка " + count + " файла началась");
            count++;
        }
    }
}
