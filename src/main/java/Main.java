public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Steve");
        Player player2 = new Player("Bill");

        TicTacToe jogoDaVelha = new TicTacToe(player1, player2);

        jogoDaVelha.initTicTacToe();

    }


}
