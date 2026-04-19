package Services;

import Models.NewsClassification;

/**
 * Responsible for applying the criteria for automatic news analysis.
 *
 * The classification is calculated by a score based on the absence of a source,
 * sensationalist language and reduced text size.
 */

public class NewsAnalyzer {
    private static final int MINIMUM_RELIABLE_TEXT_LENGTH = 10;

    public NewsAnalyzer() { }

    /**
     * It analyzes the provided text and returns an automatic classification.
     *
     * @param text text of the news to be analyzed
     * @return calculated classification for the news
     */
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
