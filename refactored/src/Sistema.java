import Models.News;
import Models.NewsClassification;
import Services.NewsAnalyzer;
import Services.NewsCatalog;

import java.util.Scanner;

public class Sistema {

    private static final NewsCatalog newsCatalog = new NewsCatalog();
    private static final NewsAnalyzer newsAnalyzer = new NewsAnalyzer();

    // função que faz tudo
    public static void addNews(String newsText, NewsClassification newsClassification) {
        // adiciona coisa
        if (newsText != null && !newsText.equals("")) {
            News noticia = new News();
            noticia.setText(newsText);

            if (newsClassification == null || newsClassification.getLabel().equals("")) {
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
        NewsClassification classification = NewsClassification.fromLabel(sc.nextLine());

        if (classification.getLabel().equals("")) {
            addNews(text, null);
        } else {
            addNews(text, classification);
        }
    }

    public static void addAuto(Scanner sc) {
        System.out.print("Digite o text: ");
        String text = sc.nextLine();

        NewsClassification classification = newsAnalyzer.analyze(text);
        addNews(text, classification);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenuOptions();

            String option = sc.nextLine();

            if (!handleMenuOption(option, sc)) {
                break;
            }
        }

        sc.close();
    }

    private static void showMenuOptions() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    private static boolean handleMenuOption(String option, Scanner sc) {
        if (option.equals("1")) {
            addManual(sc);
            return true;
        }

        if (option.equals("2")) {
            addAuto(sc);
            return true;
        }

        if (option.equals("3")) {
            listNews();
            return true;
        }

        if (option.equals("4")) {
            return false;
        }

        System.out.println("Opcao invalida.");
        return true;
    }
}
