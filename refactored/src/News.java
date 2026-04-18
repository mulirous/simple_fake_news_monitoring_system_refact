class News {
    private String text;
    private String classification;


    public News(String text, String classification) {
        this.text = text;
        this.classification = classification;
    }

    public News() { }

    public String getText() {
        return text;
    }

    public String getClassification() {
        return classification;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

}