package gamelibrary.members;

public class Member {
    private String name;
    
    public Member(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
