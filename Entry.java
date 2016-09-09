/**
 * Created by ashleyjain on 22/08/16.
 */
public class Entry implements Comparable<Entry> {
    private int key;
    private int value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Entry other) {
        return other.key-this.key;
    }
}
