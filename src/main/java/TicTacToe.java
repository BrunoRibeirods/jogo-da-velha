import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    int jogadas = 0;
    Player actualPlayer;
    Player winnerPlayer;
    Player playerX;
    Player playerO;
    String[][] gameResult = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    TicTacToe(Player player1, Player player2) {
        chooseTeam(player1, player2);
    }

    private void chooseTeam(Player player1, Player player2) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\n%s escolha entre X ou O: ", player1.name);
        String player1Pick = sc.nextLine();
        if (player1Pick == "x") {
            playerX = player1;
            playerO = player2;
            actualPlayer = playerX;
        } else {
            playerX = player2;
            playerO = player1;
            actualPlayer = playerO;
        }
        System.out.println("\nVamos começar!!");
    }

    public void initTicTacToe() {
        Scanner sc = new Scanner(System.in);
        ticTacToeLayout();
        if(jogadas > 0) verifyActualPlayer();
        System.out.printf("\n%s escolha sua opcao: ", actualPlayer.name);
        String playerOpt = sc.nextLine();
        playerChoose(playerOpt, actualPlayer);

    }

    private void verifyActualPlayer(){
            if (actualPlayer == playerX) {
                actualPlayer = playerO;
            } else {
                actualPlayer = playerX;
            }
    }

    public void ticTacToeLayout() {
        System.out.println("\n");
        for (int row = 0; row < gameResult.length; row++) {
            for (int column = 0; column < gameResult[row].length; column++) {
                if (column == 1) {
                    System.out.print(" | " + gameResult[row][column] + " | ");
                } else {
                    System.out.print(gameResult[row][column]);
                }

            }
            if (row <= 1) {
                System.out.println("\n_________\n");
            }
        }
        System.out.println("\n");
    }

    public void setPlayerOpt(String opt, String userObj) {
        for (int row = 0; row < gameResult.length; row++) {
            for (int column = 0; column < gameResult[row].length; column++) {
                if (Objects.equals(gameResult[row][column], opt)) {
                    gameResult[row][column] = userObj;
                }
            }
        }
    }

    private void playerChoose(String opt, Player player) {
        String userChar;
        if (player == playerX) {
            userChar = "x";
        } else {
            userChar = "o";
        }
        if (Integer.parseInt(opt) > 0 && Integer.parseInt(opt) < 10) {
            setPlayerOpt(opt, userChar.toUpperCase());
            ticTacToeLayout();
            verifyResults();
        }
    }

    private void verifyResults() {
        jogadas++;
        if (verifyDiagonal() || verifyVertical() || verifyHorizontal()) {
            winnerPlayer = actualPlayer;
            System.out.println("O jogador vencedor foi: " + winnerPlayer.name + "!!!!!! \n\n");
            return;
        } else if(jogadas == 9) {
            System.out.println("Ihh deu velha!");
            return;
        }else{
            initTicTacToe();
        }
    }

    private boolean verifyDiagonal() {
        return Objects.equals(gameResult[0][0], gameResult[1][1]) && Objects.equals(gameResult[1][1], gameResult[2][2]) ||
                Objects.equals(gameResult[2][0], gameResult[1][1]) && Objects.equals(gameResult[1][1], gameResult[0][2]);
    }

    private boolean verifyVertical() {
        return Objects.equals(gameResult[0][0], gameResult[0][1]) && Objects.equals(gameResult[0][1], gameResult[0][2]) ||
                Objects.equals(gameResult[1][0], gameResult[1][1]) && Objects.equals(gameResult[1][1], gameResult[1][2]) ||
                Objects.equals(gameResult[2][0], gameResult[2][1]) && Objects.equals(gameResult[2][1], gameResult[2][2]);
    }

    private boolean verifyHorizontal() {
        return Objects.equals(gameResult[0][0], gameResult[1][0]) && Objects.equals(gameResult[1][0], gameResult[2][0]) ||
                Objects.equals(gameResult[0][1], gameResult[1][1]) && Objects.equals(gameResult[1][1], gameResult[2][1]) ||
                Objects.equals(gameResult[0][2], gameResult[1][2]) && Objects.equals(gameResult[1][2], gameResult[2][2]);
    }


}
