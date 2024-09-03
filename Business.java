public class Business {
    private String first;
    private String last;

    public Business(String first, String last){
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    public static void main(String[] args) {
        System.out.println("A tests 3!");
        Business bus1 = new Business("THISname", "Thatname");
        Business bus2 = new Business(bus1.getFirst(), bus1.getLast());
        Business bus3 = bus1;
        System.out.println(bus3.getFirst());
        System.out.println(bus3.getLast());
    }
}
