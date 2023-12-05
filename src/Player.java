import java.util.LinkedList;
import java.util.List;

public class Player {

    private String name;
    private final String emoji = "🕵🏽‍♂️️";

    List<Object> detectiveBag = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }
}
