package GameCore;


public abstract class Cards {
    public String name;
    public String clueSus;
    public String clueNonSus;

    public boolean wasUsedToKill;

    public String getClueSus() {
        return clueSus;
    }

    public String getClueNonSus() {
        return clueNonSus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
