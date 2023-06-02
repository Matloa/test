
public class Player {

    public String playerName;
    public int place;
    public int AmountOfgoldCoins;
    public boolean inPenaltyBox;

    public Player(String playerName, int place, int AmountOfgoldCoins, boolean inPenaltyBox) {

        this.playerName = playerName;
        this.place = place;
        this.AmountOfgoldCoins = AmountOfgoldCoins;
        this.inPenaltyBox = inPenaltyBox;

    }

    public int getPlace() {
        return place;
    }

    public int getPurses() {
        return AmountOfgoldCoins;
    }

    public boolean getinPenaltyBox() {
        return inPenaltyBox;
    }

    public String getname() {
        return playerName;
    }

    public int SetPlace(int i) {
        place = i;
        return place;
    }

    public int SetPurses(int i) {
        AmountOfgoldCoins = i;
        return AmountOfgoldCoins;
    }

    public boolean SetinPenaltyBox(boolean i) {
        inPenaltyBox = i;
        return inPenaltyBox;
    }

    public String Setname(String i) {
        playerName = i;
        return playerName;
    }
}