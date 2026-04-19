import Models.News;
import Models.NewsClassification;
import Services.NewsAnalyzer;
import Services.NewsCatalog;

import java.util.Scanner;

/**
 * Main orchestration class of the system.
 *
 * Maintains the flow of interaction with the user via the console and delegates the
 * responsresponsibilities of analysis and storage to specialized classes.
 */
public class Sistema {

    private static final NewsCatalog newsCatalog = new NewsCatalog();
    private static final NewsAnalyzer newsAnalyzer = new NewsAnalyzer();

    /**
     * Register a news on catalog. If the classification is not provided,
     * the system uses DUVIDOSA as the default classification, preserving the behavior of the original code.
     *
     * @param newsText news text
     * @param newsClassification news classification
     */
    public static void addNews(String newsText, NewsClassification newsClassification) {
        if (newsText == null || newsText.isBlank()) {
            System.out.println("Texto invalido.");
            return;
        }

        NewsClassification classification = newsClassification == null
                ? NewsClassification.DUVIDOSA
                : newsClassification;

        News news = new News(newsText, classification);
        newsCatalog.add(news);
    }

    /**
     * List the news registered in the system.
     */
    public static void listNews() {
        if (newsCatalog.isEmpty()) {
            System.out.println("Nenhuma noticia cadastrada.");
            return;
        }

        for (News news : newsCatalog.list()) {
            System.out.println("Texto: " + news.getText());
            System.out.println("Classificacao: " + news.getClassificationLabel());
            System.out.println("-------------------");
        }
    }

    /**
     * Read the news data manually entered by the user. If the classification is not provided,
     * the system uses DUVIDOSA as the default classification, preserving the behavior of the original code.
     *
     * @param sc scanner used for reading user input when necessary
     */
    public static void addManual(Scanner sc) {
        System.out.print("Digite o texto: ");
        String text = sc.nextLine();

        System.out.print("Digite classificacao: ");
        String classificationInput = sc.nextLine();

        if (classificationInput.isBlank()) {
            addNews(text, NewsClassification.DUVIDOSA);
            return;
        }

        try {
            NewsClassification classification = NewsClassification.fromLabel(classificationInput);
            addNews(text, classification);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Read the user text and applies the automatic classification
     *
     * @param sc scanner used for reading user input when necessary
     */
    public static void addAuto(Scanner sc) {
        System.out.print("Digite o texto: ");
        String text = sc.nextLine();

        if (text == null || text.isBlank()) {
            System.out.println("Texto invalido.");
            return;
        }

        NewsClassification classification = newsAnalyzer.analyze(text);
        addNews(text, classification);
    }

    /**
     * Start the menu console system
     */

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

    /**
     * Display the menu options on console.
     */
    private static void showMenuOptions() {
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    /**
     *
     * @param option user-selected menu option
     * @param sc scanner used for reading user input when necessary
     * @return true if the menu should continue, false if it should exit
     */
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
