public class SeaBoard {
    final int UP = 0;
    final int LEFT = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    private String[][] field = new String[10][10];

    public SeaBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = ".";
            }
        }
    }

    public String[][] getField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        return field;
    }

    public void shoot(int line, int column, String issue) {

        switch (issue) {
            case "m":
                field[line][column] = "#";
                break;
            case "d":
                field[line][column] = "x";
                check(line, column);
                for (int d = UP; d <= RIGHT ; d++) {
                    findEnd(line, column, d);
                }
                break;
            case "h":
                field[line][column] = "x";
//                check(line, column);
                break;
        }
    }

// проверяем, находится ли клетка в пределах поля
    private boolean exists(int l, int c) {
        return  ( l >= 0 & l <=9 & c >= 0 & c <=9 );
    }

// после потопления ищем крайние клетки корабля по четырем направлениям и отмечаем следующую клетку "#"
    private void findEnd (int l, int c, int direction) {
        int nextL = l;
        int nextC = c;
        switch (direction) {
            case UP:
                nextL--;
                break;
            case LEFT:
                nextC--;
                break;
            case DOWN:
                nextL++;
                break;
            case RIGHT:
                nextC++;
                break;
        }
        if (exists(nextL, nextC)){
            if (field[nextL][nextC] == "x") {
// по диагонали от попадания отмечаем "#"
                check(nextL, nextC);
// ищем крайнюю клетку в том же направлении
                findEnd( nextL, nextC, direction);
            }
            else if (field[nextL][nextC] == ".") field[nextL][nextC] = "#";
            }
    }

    
    private void fillIfExists(int l, int c, String status){
        if ( exists(l, c) ) field[l][c] = status;

    }
// заполняем клетки по диагонали от попадания
    public String check(int line, int column) {
        fillIfExists(line - 1, column - 1, "#");
        fillIfExists(line - 1, column + 1, "#");
        fillIfExists(line + 1, column - 1, "#");
        fillIfExists(line + 1, column + 1, "#");
        return field[line][column];
    }
}

