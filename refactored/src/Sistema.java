import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private static NewsCatalog newsCatalog = new NewsCatalog();
    private static NewsAnalyzer newsAnalyzer = new NewsAnalyzer();

    // função que faz tudo
    public static void addNews(String newsText, String newsClassification) {
        // adiciona coisa
        if (newsText != null && !newsText.equals("")) {
            News noticia = new News();
            noticia.setText(newsText);

            if (newsClassification == null || newsClassification.equals("")) {
                noticia.setClassification("duvidosa");
            } else {
                noticia.setClassification(newsClassification);
            }

            newsCatalog.add(noticia);
        } else {
            System.out.println("erro");
        }
    }

    public static void listNews() {
        // lista tudo
        for (News news : newsCatalog.list()) {
            System.out.println("Texto: " + news.getText());
            System.out.println("Classificacao: " + news.getClassificationLabel());
            System.out.println("-------------------");
        }
    }

    public static void addManual(Scanner sc) {
        System.out.print("Digite o text: ");
        String text = sc.nextLine();

        System.out.print("Digite classification: ");
        String classification = sc.nextLine();

        if (classification.equals("")) {
            addNews(text, null);
        } else {
            addNews(text, classification);
        }
    }

    public static void addAuto(Scanner sc) {
        System.out.print("Digite o text: ");
        String text = sc.nextLine();

        String classification = newsAnalyzer.analyze(text);
        addNews(text, classification);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - adicionar manual");
            System.out.println("2 - adicionar automatico");
            System.out.println("3 - listar");
            System.out.println("4 - sair");

            String op = sc.nextLine();

            if (op.equals("1")) {
                addManual(sc);
            } else if (op.equals("2")) {
                addAuto(sc);
            } else if (op.equals("3")) {
                listNews();
            } else if (op.equals("4")) {
                break;
            } else {
                System.out.println("errado");
            }
        }

        sc.close();
    }
}
