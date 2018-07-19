package pl.razor.SocialMediaVote.Entities;

public class Participant {

    private long id;
    private String name;
    private int score;

    Participant(){
        setScore(0);
    }

    public Participant(long id, String name, int score){
        setId(id);
        setName(name);
        setScore(score);
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
