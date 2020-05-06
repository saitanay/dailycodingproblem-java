import java.util.ArrayList;
import java.util.HashMap;

public class Boggle {

    private HashMap<Point, Character> boggleMatrix = new HashMap<>();
    private ArrayList<String> validWords = new ArrayList<>();

    public Boggle(char[] chars, String[] validWords) {
        this.setMatrix(chars);
        this.setValidWords(validWords);
    }

    private void setMatrix(char[] c) {
        int k = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Point currentPoint = new Point(i, j);
                this.boggleMatrix.put(currentPoint, c[k]);
                k++;
            }
        }
    }

    private void setValidWords(String[] s) {
        for (int i = 0; i < s.length; i++) {
            this.validWords.add(s[i]);
        }
    }

    public ArrayList<String> findPossibleWords() {
        ArrayList<String> foundWords = new ArrayList<>();
        for (String word : this.validWords) {
            if (this.checkIfWordExists(word)) {
                foundWords.add(word);
            }
        }
        return foundWords;
    }

    public boolean canStringCanBeTraversedFromaPoint(String word, Point p, ArrayList usedPoints) {
        //Assuming first letter exists in Point P
        if (word.length() == 1) {
            return true;
        }
        ArrayList<Point> adjPoints = findAdjacentCharPositions(p);
        for (Point q : adjPoints) {
            if (
                    (this.boggleMatrix.get(q) == word.charAt(1))
                            &&
                            (!usedPoints.contains(q))
            ) {
                usedPoints.add(p);
                usedPoints.add(q);
                ArrayList newUsedPoints = new ArrayList();
                newUsedPoints = usedPoints;
                return canStringCanBeTraversedFromaPoint(word.substring(1), q, newUsedPoints);
            }

        }
        return false;
    }

    public boolean checkIfWordExists(String word) {
        boolean wordFound = false;
        char firstChar = word.charAt(0);
        ArrayList<Point> points = getCoordinatesOfCharacter(firstChar);
        for (Point p : points) {
            if (this.canStringCanBeTraversedFromaPoint(word, p, new ArrayList())) {
                wordFound = true;
                break;
            }
        }
        return wordFound;
    }

    public ArrayList<Point> getCoordinatesOfCharacter(char c) {
        ArrayList<Point> returnCoordinates = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Point currentPoint = new Point(i, j);
                if (this.boggleMatrix.get(currentPoint) == c) {
                    returnCoordinates.add(currentPoint);
                }
            }
        }
        return returnCoordinates;
    }

    public ArrayList<Point> findAdjacentCharPositions(Point p) {
        ArrayList<Point> returnCoordinates = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Point currentPoint = new Point(i, j);
                if (p.getDistance(currentPoint) == 1) {
                    returnCoordinates.add(currentPoint);
                }
            }
        }
        return returnCoordinates;

    }

}
