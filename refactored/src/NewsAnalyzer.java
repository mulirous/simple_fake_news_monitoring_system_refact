public class NewsAnalyzer {
    public NewsAnalyzer() { }

    public String analyze(String text) {
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
            return "confiavel";
        }

        if (score == 1) {
            return "duvidosa";
        }

        return "falsa";
    }
}
