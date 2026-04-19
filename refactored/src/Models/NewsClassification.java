package Models;

/**
 * Defines the valid classifications for a news item.
 *
 * The enum avoids the use of loose strings in the code and restricts the possible values
 * to classifications known to the system.
 */
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

    /**
     * Converts user-entered text into a valid classification.
     *
     * @param label classification text
     * @return corresponding classification
     */
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
