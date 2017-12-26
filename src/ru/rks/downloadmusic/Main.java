package ru.rks.downloadmusic;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Main {
    private static final String IN_FILE_TXT = "inFile.txt";
    private static final String OUT_FILE_TXT = "outFile.txt";
    private static final String PATH_TO_MUSIC = "D:\\Work\\Threads\\src\\ru\\rks\\downloadmusic\\music\\music";

    public static void main(String[] args) {
        StartProgramm();
    }

    private static void StartProgramm() {
            try (BufferedReader inFile = new BufferedReader(new FileReader(IN_FILE_TXT))) {
                String link;
                while ((link = inFile.readLine()) != null) {
                        URL url = new URL(link);
                    ArrayList<String> arrayList = linksWriter(stringConvertor(url));
                    int count = 1;
                    for (String str : arrayList) {
                        new FileLoader(str, PATH_TO_MUSIC + String.valueOf(count) + ".mp3").start();
                        System.out.println("Загрузка " + count + " файла началсь");
                        count++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    /**
     *Метод записывает HTML-код страницы в мультистроку.
     */
    private static String stringConvertor(URL url) {
        String result= null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            result = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e1) {
            e1.printStackTrace();
    }
    return result;
        }

        private static ArrayList<String> linksWriter(String multiString){
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT))) {
            Pattern email_pattern = Pattern.compile("\\s*(?<=data-url\\s?=\\s?\")[^>]*/*(?=\")");
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
}
