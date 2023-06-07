package day0607.DartTest;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DartResultAnalyzer {
    private int DartScore;
    private String DartScoreEquation;

    public DartResultAnalyzer(String dartResult) {
        List<Integer> Score = new ArrayList<Integer>();
        List<String> ScoreEquation = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(dartResult, "0123456789", true);

        int numOfDart = 0;
        while (st.hasMoreElements()) {
            String token1 = st.nextToken();
            String token2 = st.nextToken();
            if (token1.equals("1") && token2.equals("0")) {
                token1 = "10";
                token2 = st.nextToken();
            } else {
                // NoOP
            }
            if (numOfDart == 0) {
                System.out.printf("score : %s   Option %s\n", token1, token2);
                DartScoreParser sp = new DartScoreParser(token1, token2);
                Score.add(sp.getCurScore());
                ScoreEquation.add(sp.getCurEquation());
                System.out.printf("score : %s   Equation %s\n", Score.get(numOfDart), ScoreEquation.get(numOfDart));
            } else {
                System.out.printf("score : %s   Option %s\n", token1, token2);
                DartScoreParser sp = new DartScoreParser(token1, token2, Score.get(numOfDart - 1),
                        ScoreEquation.get(numOfDart - 1));

                Score.set(numOfDart - 1, sp.getPrvScore());
                ScoreEquation.set(numOfDart - 1, sp.getPrvEquation());
                Score.add(sp.getCurScore());
                ScoreEquation.add(sp.getCurEquation());
                System.out.printf("score : %s   Equation %s\n", Score.get(numOfDart), ScoreEquation.get(numOfDart));
            }

            numOfDart++;
        }
        for (int idx = 0; idx < numOfDart; idx++) {
            DartScore += Score.get(idx);
            DartScoreEquation += ScoreEquation.get(idx) + "+";
        }

    }

    public int getDartScore() {
        return DartScore;
    }

    public String getDartScoreEquation() {
        return DartScoreEquation;
    }

}
