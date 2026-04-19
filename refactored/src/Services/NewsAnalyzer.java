package Services;

import Models.NewsClassification;

public class NewsAnalyzer {
    private static final int MINIMUM_RELIABLE_TEXT_LENGTH = 10;

    public NewsAnalyzer() { }


    public NewsClassification analyze(String text) {
        if (text == null || text.isBlank()) {
            return NewsClassification.DUVIDOSA;
        }

        int score = 0;

        if (hasNoSource(text)) {
            score++;
        }

        if (hasSensationalistLanguage(text)) {
            score++;
        }

        if (isTooShort(text)) {
            score++;
        }

        if (score == 0) {
            return NewsClassification.CONFIAVEL;
        }

        if (score == 1) {
            return NewsClassification.DUVIDOSA;
        }

        return NewsClassification.FALSA;
    }

    private boolean hasNoSource(String text) {
        return !text.contains("FONTE");
    }

    private boolean hasSensationalistLanguage(String text) {
        return text.contains("!!!") || text.contains("URGENTE");
    }

    private boolean isTooShort(String text) {
        return text.length() < MINIMUM_RELIABLE_TEXT_LENGTH;
    }

    }
