package Models;

public enum NewsClassification {
    CONFIAVEL("confiavel"),
    DUVIDOSA("duvidosa"),
    FALSA("falsa");

    private final String label;

    NewsClassification(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static NewsClassification fromLabel(String label) {
        for (NewsClassification nc : values()) {
            if (nc.label.equalsIgnoreCase(label)) {
                return nc;
            }
        }
        throw new IllegalArgumentException("Classificação inválida: " + label);
    }
}
