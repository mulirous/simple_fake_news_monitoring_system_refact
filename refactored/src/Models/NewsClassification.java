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
        if (label == null || label.isBlank()) {
            return DUVIDOSA; // padrão para classificação duvidosa
        }

        String normalizedLabel = label.trim();

        for (NewsClassification nc : values()) {
            if (nc.label.equalsIgnoreCase(normalizedLabel)) {
                return nc;
            }
        }
        throw new IllegalArgumentException("Classificação inválida: " + label);
    }
}
