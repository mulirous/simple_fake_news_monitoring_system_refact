package Services;

import Models.NewsClassification;

public class NewsAnalyzer {
    public NewsAnalyzer() { }

    public NewsClassification analyze(String text) {
        int score = 0;

        if (!text.contains("FONTE")) {
            score++;
        }

        if (text.contains("!!!")) {
            score++;
        }

        if (text.contains("URGENTE")) {
            score++;
        }

        if (text.length() < 10) {
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
}
