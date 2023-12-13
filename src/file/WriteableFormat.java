package file;

public class WriteableFormat {
    Long time;
    String name;

    public WriteableFormat(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Long getTime() {
        return time;
    }

    public String toString() {
        return this.name + "-" + this.time;
    }


    public static String formatTime(Long totalTime) {
        long seconds = totalTime / 1_000;
        long minutes = seconds / 60;
        seconds = seconds % 60;

        String formattedDuration = String.format("%02d:%02d", minutes, seconds);
        return formattedDuration;
    }
}