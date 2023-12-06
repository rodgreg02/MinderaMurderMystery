package gameCore;

import room.Room;

public class Render {
    public static void drawMap(Room[] rooms) {
        int size = rooms.length;
        int rows = 3;
        int cols = 3;


        int row, col;


        int poolIndex = size - 1;


        int centerIndex = (rows * cols - 1) / 2;
        Room temp = rooms[centerIndex];
        rooms[centerIndex] = rooms[poolIndex];
        rooms[poolIndex] = temp;


        for (row = 0; row < rows; row++) {

            for (col = 0; col < cols; col++) {
                System.out.print("+----------+");
            }
            System.out.println();


            for (col = 0; col < cols; col++) {
                int currentIndex = (row * cols) + col;
                if (currentIndex < size) {
                    String roomName = rooms[currentIndex].getName();
                    System.out.printf("|  %-8s", roomName);
                } else {
                    System.out.print("|        ");
                }
            }
            System.out.println("|");

            // Print lower horizontal row
            for (col = 0; col < cols; col++) {
                System.out.print("+----------+");
            }
            System.out.println();
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
}

