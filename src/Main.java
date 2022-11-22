public class Main {

    public static final String m = "miss";
    public static final String h = "hit";
    public static final String d = "destroy";

    public static void main(String[] args) {

        SeaBoard board = new SeaBoard();
        board.shoot(0, 0, m);
        board.getField();
//        System.out.println();
//        board.shoot(2, 0, h);
//        board.getField();
//        System.out.println();
//        board.shoot(6, 9, h);
//        board.getField();
//        System.out.println();
//        board.shoot(2, 1, d);
//        board.getField();
//        System.out.println();
//        board = new SeaBoard();
        board.shoot(2, 0, "h");
        board.shoot(2, 8, "d");
        board.shoot(6, 9, "h");
        board.shoot(2, 2, "m");
        board.shoot(0, 0, "m");
        board.shoot(5, 2, "m");
        board.shoot(7, 0, "h");
        board.shoot(7, 1, "h");
        board.shoot(7, 2, "h");
        board.shoot(7, 3, "d");
        board.shoot(9, 7, "h");
        board.shoot(8, 7, "d");
        board.getField();



    }
}