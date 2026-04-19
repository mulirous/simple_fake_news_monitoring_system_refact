package Models;

public class News {
    private String text;
    private NewsClassification classification;


    public News(String text, NewsClassification classification) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Texto da noticia nao pode ser vazio.");
        }

        if (classification == null) {
            throw new IllegalArgumentException("Classificacao da noticia nao pode ser nula.");
        }

        this.text = text.trim();
        this.classification = classification;
    }

    public News() { }

    public String getText() {
        return text;
    }

    public NewsClassification getClassification() {
        return classification;
    }

    public String getClassificationLabel() {
        return classification.getLabel();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setClassification(String classification) {
        this.classification = NewsClassification.fromLabel(classification);
    }

    public void setClassification(NewsClassification classification) {
        this.classification = classification;
    }

}