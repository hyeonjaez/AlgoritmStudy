class Solution {
    public String solution(int[] numbers, String hand) {
        Position[] now = new Position[2];
        now[0] = new Position(3, 0);
        now[1] = new Position(3, 2);

        Position[] map = new Position[10];

        map[1] = new Position(0, 0);
        map[2] = new Position(0, 1);
        map[3] = new Position(0, 2);
        map[4] = new Position(1, 0);
        map[5] = new Position(1, 1);
        map[6] = new Position(1, 2);
        map[7] = new Position(2, 0);
        map[8] = new Position(2, 1);
        map[9] = new Position(2, 2);
        map[0] = new Position(3, 1);
        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            String nowNumber = getHand(number);
            Position nowPosition = map[number];
            if (nowNumber.equals("M")) {

                int left = getDistance(now[0], nowPosition);
                int right = getDistance(now[1], nowPosition);

                if (left > right) {
                    sb.append("R");
                    now[1] = nowPosition;
                } else if (left < right) {
                    sb.append("L");
                    now[0] = nowPosition;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        now[1] = nowPosition;
                    } else {
                        sb.append("L");
                        now[0] = nowPosition;
                    }
                }
                continue;
            }

            if (nowNumber.equals("L")) {
                sb.append("L");
                now[0] = nowPosition;
            } else {
                sb.append("R");
                now[1] = nowPosition;
            }
        }

        return sb.toString();
    }

    public String getHand(int number) {
        if (number == 0) {
            return "M";
        }
        if (number % 3 == 0) {
            return "R";
        } else if (number % 3 == 1) {
            return "L";
        }
        return "M";
    }

    public int getDistance(Position a, Position b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    
    
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}