package _08_clean_code_refactoring.exercise;

public class TennisGame {

    public static final int POINT_LOVE = 0;
    public static final int POINT_FIFTEEN = 1;
    public static final int POINT_THIRTY = 2;
    public static final int POINT_FORTY = 3;

    public static String getScoring(String player1Name, String player2Name, int player1Point, int player2Point) {
        String scoring ;
        if (player1Point == player2Point) {
            scoring = getPointAll(player1Point);
        } else if (player1Point >= 4 || player2Point >= 4) {
            scoring = checkWin(player1Point, player2Point);
        } else {
            scoring = getPoint(player1Point, player2Point);
        }
        return scoring;
    }

    private static String getPointAll(int player1Point) {
        String scoring;
        switch (player1Point) {
            case POINT_LOVE:
                scoring = "Love-All";
                break;
            case POINT_FIFTEEN:
                scoring = "Fifteen-All";
                break;
            case POINT_THIRTY:
                scoring = "Thirty-All";
                break;
            case POINT_FORTY:
                scoring = "Forty-All";
                break;
            default:
                scoring = "Deuce";
                break;

        }
        return scoring;
    }

    public static String getPoint(int player1Point, int player2Point) {
        StringBuilder scoring = new StringBuilder();
        int tempPoint;
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                tempPoint = player1Point;
            } else {
                scoring.append("-");
                tempPoint = player2Point;
            }
            switch (tempPoint) {
                case POINT_LOVE:
                    scoring.append("Love");
                    break;
                case POINT_FIFTEEN:
                    scoring.append("Fifteen");
                    break;
                case POINT_THIRTY:
                    scoring.append("Thirty");
                    break;
                case POINT_FORTY:
                    scoring.append("Forty");
                    break;
            }
        }

        return scoring.toString();
    }

    private static String checkWin(int player1Point, int player2Point) {
        String scoring;
        int minusResult = player1Point - player2Point;
        if (minusResult == 1) {
            scoring = "Advantage player1";
        } else if (minusResult == -1) {
            scoring = "Advantage player2";
        } else if (minusResult >= 2) {
            scoring = "Win for player1";
        } else {
            scoring = "Win for player2";
        }
        return scoring;
    }
}
