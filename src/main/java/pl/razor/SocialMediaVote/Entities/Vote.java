package pl.razor.SocialMediaVote.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection
    protected List<String> votes;
    private String voterName;

    public Vote(){}

    Vote(List<String> votes, String voterName){
        setVotes(votes);
        setVoterName(voterName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterName() {
        return voterName;
    }

    public List<String> getVotes() {
        return votes;
    }


    public void setVotes(List<String> votes) {
        this.votes = votes;
    }
}
