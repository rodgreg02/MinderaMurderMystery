package file;

public class WriteableFormat {
    Long time;
    String name;

    public WriteableFormat( String name,Long time) {
        this.name = name;
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public String toString(){
        return this.name + "-" + this.time;
    }
}
