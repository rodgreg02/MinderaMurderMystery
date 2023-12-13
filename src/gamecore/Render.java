package gamecore;

import room.Room;

import java.util.ArrayList;

public class Render {
    public static void drawMap(ArrayList<Room> rooms0) {
        Room[] rooms = rooms0.toArray(new Room[0]);
        int size = rooms.length;
        int rows = 3;
        int cols = 3;


        int row, col;


        int poolIndex = size - 1;


        int centerIndex = (rows * cols - 1) / 2;
        Room temp = rooms[centerIndex];
        rooms[centerIndex] = rooms[poolIndex];
        rooms[poolIndex] = temp;
        System.out.println();
        System.out.println("\t\t\t\t\t\tFlávio House");
        for (row = 0; row < rows; row++) {

            System.out.println("+-----------------------------------------------------------+");

            for (col = 0; col < cols; col++) {
                int currentIndex = (row * cols) + col;
                if (currentIndex < size) {
                    String roomName = rooms[currentIndex].getName();
                    System.out.print("|\t" + String.format("%-15s", roomName));
                }
            }
            System.out.println(" |");

            System.out.println("+-----------------------------------------------------------+");
        }
    }

    public static void drawRoom(Room currentRoom) {
        String roomName = currentRoom.getName();
        int nameLength = roomName.length();


        System.out.print("-------------");
        System.out.print(currentRoom.getName());
        System.out.println("------------");

        for (int i = 0; i < 10; i++) {
            System.out.println("|" + String.format("%" + (nameLength + 24) + "s", "|"));
        }

        System.out.print("-------------");
        System.out.print(currentRoom.getName());
        System.out.println("------------");
    }

    public static void printStory(String stringToPrint) {
        for (int i = 0; i < stringToPrint.length(); i++) {
            char letter = stringToPrint.charAt(i);

            // Print one character at a time
            System.out.print(letter);

            // You can add a delay if you want to visualize each character being printed
            try {
                Thread.sleep(100); // Adjust the delay time (in milliseconds) if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

