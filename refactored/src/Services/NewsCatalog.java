package Services;

import Models.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages the stored database of news items.
 *
 * This class centralizes operations on the news list, preventing
 * the main class from directly manipulating the storage structure.
 */
public class NewsCatalog {
    private List<News> newsList = new ArrayList<>();

    /**
     * Add a news on catalog list.
     *
     * @param news news story to be added
     */
    public void add(News news) {
        if (news == null) {
            throw new IllegalArgumentException("Noticia nao pode ser nula.");
        }

        newsList.add(news);
    }

    public List<News> list() {
        return Collections.unmodifiableList(newsList);
    }

    public boolean isEmpty() {
        return newsList.isEmpty();
    }
}
