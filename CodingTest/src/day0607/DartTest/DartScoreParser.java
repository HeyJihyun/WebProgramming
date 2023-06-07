package day0607.DartTest;

public class DartScoreParser {
    private int curScore;
    private String curEquation;
    private int prvScore;
    private String prvEquation;

    public DartScoreParser(String token1, String token2) {
        if (token2.charAt(0) == 'S' || token2.charAt(0) == 's') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = Integer.parseInt(token1) * 2;
                    curEquation = token1 + "^1*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = Integer.parseInt(token1) * (-1);
                    curEquation = token1 + "^1*(-1)";
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = Integer.parseInt(token1);
                curEquation = token1 + "^1";
            }
        } else if (token2.charAt(0) == 'D' || token2.charAt(0) == 'd') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = (int) (Math.pow(Integer.parseInt(token1), 2) * 2);
                    curEquation = token1 + "^2*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = (int) (Math.pow(Integer.parseInt(token1), 2) * (-1));
                    curEquation = token1 + "^2*(-1)";
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = (int) Math.pow(Integer.parseInt(token1), 2);
                curEquation = token1 + "^2";
            }
        } else if (token2.charAt(0) == 'T' || token2.charAt(0) == 't') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = (int) Math.pow(Integer.parseInt(token1), 3) * 2;
                    curEquation = token1 + "^1*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = (int) Math.pow(Integer.parseInt(token1), 3) * (-1);
                    curEquation = token1 + "^1*(-1)";
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = (int) Math.pow(Integer.parseInt(token1), 3);
                curEquation = token1 + "^3";
            }
        } else {
            System.out.println("Error : Use only S, D , T!!!");
        }
    }

    public DartScoreParser(String token1, String token2, int prevScore, String prevScoreEquation) {
        if (token2.charAt(0) == 'S' || token2.charAt(0) == 's') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = Integer.parseInt(token1) * 2;
                    curEquation = token1 + "^1*2";
                    prvScore = prevScore * 2;
                    prvEquation = prevScoreEquation + "*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = Integer.parseInt(token1) * (-1);
                    curEquation = token1 + "^1*(-1)";
                    prvScore = prevScore;
                    prvEquation = prevScoreEquation;
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = Integer.parseInt(token1);
                curEquation = token1 + "^1";
                prvScore = prevScore;
                prvEquation = prevScoreEquation;
            }
        } else if (token2.charAt(0) == 'D' || token2.charAt(0) == 'd') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = (int) (Math.pow(Integer.parseInt(token1), 2) * 2);
                    curEquation = token1 + "^2*2";
                    prvScore = prevScore * 2;
                    prvEquation = prevScoreEquation + "*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = (int) (Math.pow(Integer.parseInt(token1), 2) * (-1));
                    curEquation = token1 + "^2*(-1)";
                    prvScore = prevScore;
                    prvEquation = prevScoreEquation;
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = (int) Math.pow(Integer.parseInt(token1), 2);
                curEquation = token1 + "^2";
                prvScore = prevScore;
                prvEquation = prevScoreEquation;
            }
        } else if (token2.charAt(0) == 'T' || token2.charAt(0) == 't') {
            if (token2.length() > 1) {
                if (token2.charAt(1) == '*') {
                    curScore = (int) Math.pow(Integer.parseInt(token1), 3) * 2;
                    curEquation = token1 + "^1*2";
                    prvScore = prevScore * 2;
                    prvEquation = prevScoreEquation + "*2";
                } else if (token2.charAt(1) == '#') {
                    curScore = (int) Math.pow(Integer.parseInt(token1), 3) * (-1);
                    curEquation = token1 + "^1*(-1)";
                    prvScore = prevScore;
                    prvEquation = prevScoreEquation;
                } else {
                    System.out.println("Use Only *, #");
                }
            } else {
                curScore = (int) Math.pow(Integer.parseInt(token1), 3);
                curEquation = token1 + "^3";
                prvScore = prevScore;
                prvEquation = prevScoreEquation;
            }
        } else {
            System.out.println("Error : Use only S, D , T!!!");
        }
    }

    public int getCurScore() {
        return curScore;
    }

    public String getCurEquation() {
        return curEquation;
    }

    public int getPrvScore() {
        return prvScore;
    }

    public String getPrvEquation() {
        return prvEquation;
    }

}
