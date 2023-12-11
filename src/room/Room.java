package room;
import gameCore.Game;
import gameCore.Card;

import java.util.ArrayList;


public class Room extends Card {
    private Card clue;

    public Room(String name,String clueSus,String clueNonSus){
        this.name = name;
        this.clueSus = clueSus;
        this.clueNonSus = clueNonSus;
    }

    public static ArrayList<Room> rooms = new ArrayList<>();

    public static void createMap() {
        Room hall = new Room("Hall","The echoes of footsteps linger here, marking the passage of hurried movements","The stillness in this space holds secrets undisturbed, witnessing no part in the fateful event.");
        rooms.add(hall);
        Room livingRoom = new Room("Living Room","Amidst the comfort of sofas lies a faint stain, a silent witness to a disruptive event.","Tranquility reigns here undisturbed, the ambiance untouched by the shadows of the unfortunate incident.");
        rooms.add(livingRoom);
        Room gameRoom = new Room("Game Room","The disarray of game pieces betrays a struggle, hinting at a chaotic turn within these walls.","Silence prevails amidst the ordered arrangement of games, untouched by the events that unfolded elsewhere.");
        rooms.add(gameRoom);
        Room kitchen = new Room("Kitchen","Traces of an interrupted meal linger, amidst the chaos of overturned cookware, bearing witness to a sudden disturbance.","Order and cleanliness reign here, untouched by the turmoil that unfolded in other quarters.");
        rooms.add(kitchen);
        Room partyRoom = new Room("Party Room","Lingering confetti conceals secrets amidst scattered remnants, a silent witness to an unexpected turn.","Echoes of laughter resonate, untouched by the shadows that shroud events elsewhere.");
        rooms.add(partyRoom);
        Room musicRoom = new Room("Music Room","A discordant note lingers amidst the serenity, a silent melody of disruption in the air.","Harmony resonates undisturbed, the tranquil space untouched by the discordance that unfolded elsewhere.");
        rooms.add(musicRoom);
        Room library = new Room("Library","Pages of knowledge disrupted, a silent testimony to a disturbance in the pursuit of truth.","The stillness of wisdom reigns here undisturbed, untouched by the shadows that cloud other realms.");
        rooms.add(library);
        Room office = new Room("Office","Papers scattered in disarray, a silent witness to hurried searches and frantic moments.","Order and precision prevail, untouched by the turmoil that shadows other spaces.");
        rooms.add(office);
        Room pool = new Room("Pool","You smell chlorine","You smell a dead body");
        rooms.add(pool);
    }

    public String getClueObject() {
            return clue.toString();
    }

    public String getClueRoom(){
        return this.getClue();
    }

    public void setClue(Card clue) {
        this.clue = clue;
    }

    public static void distributeClues(ArrayList<Card> allClues){
        int i = 0;
        ArrayList<Integer> filledRooms = new ArrayList<>();
        ArrayList<Card> selectedClues = Game.selectClues(allClues);
        while(filledRooms.size() != 8){
            int randomNumb = Game.randomNumberGenerator(8);
            if(!filledRooms.contains(randomNumb)) {
                rooms.get(randomNumb).setClue(selectedClues.get(i));
                filledRooms.add(randomNumb);
                i++;
            }
        }
    }

    public static void chooseRandomRoomKill() {
        int valueRandom = (Game.randomNumberGenerator(7));
        Room.rooms.get(valueRandom).setWasUsedToKill(true);
    }


    public Card getClues() {
        return clue;
    }


}
