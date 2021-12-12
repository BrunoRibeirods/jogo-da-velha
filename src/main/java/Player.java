public class Player {
    String name;
    int wins;
    int losses;

    Player(String name){
        this.name = name;
    }

    public void increaseWins(){
        wins++;
    }

    public void increaseLosses(){
        losses++;
    }
}
