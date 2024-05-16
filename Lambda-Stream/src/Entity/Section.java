package Entity;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String name;
    private List<Learner> members;

    public Section(String name) {
        this.name = name;
        members = new ArrayList<>();
    }

    public void addMember(Learner member) {
        members.add(member);
    }

    public String getName() {
        return name;
    }

    public List<Learner> getMembers() {
        return members;
    }

}
