package gamecore;


public abstract class Card {
    public String name;
    public String clueSus;
    public String clueNonSus;
    public boolean wasUsedToKill;

    public String getClue() {
        return (this.wasUsedToKill)?clueSus:clueNonSus;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWasUsedToKill(boolean wasUsedToKill) {
        this.wasUsedToKill = wasUsedToKill;
    }

    public boolean getWasUsedToKill() {
        return wasUsedToKill;
    }

    public String toString(){
        return this.getClue();
    }
}
