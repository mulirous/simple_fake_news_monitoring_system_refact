package Services;

import Models.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsCatalog {
    private List<News> newsList = new ArrayList<>();

    public void add(News news) {
        newsList.add(news);
    }

    public List<News> list() {
        return Collections.unmodifiableList(newsList);
    }

}
