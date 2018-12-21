package zadania;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main5 {

    public static void main(String args[]) {
        getTitles("http://www.onet.pl/");
        getTitles("http://www.gazeta.pl/");
        getTitles("http://www.interia.pl/");
        copyWithoutPopularWords("popular_words.txt", "filtered_popular_words.txt", "\n");

    }

    public static void getTitles(String url) {
        Connection connect = Jsoup.connect(url);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
//                if (elem.text().length() > 3 && !skippedElements(elem.text())) {
//                    writeToFile(elem.text(), "filtered_popular_words.txt", "\n");
//                    System.out.println(elem.text());
//                }
                writeToFile(elem.text(), "popular_words.txt", "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean skippedElements(String text) {
        String[] skippedElements = {"oraz", "poniewaz", "alebowiem", "gdyż", "jest", "Onet24:", "które", "których", "będzie"};
        for (int i = 0; i < skippedElements.length; i++) {
            if (text == skippedElements[i]) {
                return true;
            }
        }
        return false;
    }

    public static void writeToFile(String text, String path, String add) {
        try {
            FileWriter out = new FileWriter(path, true);
            out.append(text + add);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyWithoutPopularWords(String path1, String path2, String add) {
        File file = new File(path1);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String text = scan.next();
                if (text.length() > 3 && !skippedElements(text)) {
                    writeToFile(text, path2, add);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
    }
}

