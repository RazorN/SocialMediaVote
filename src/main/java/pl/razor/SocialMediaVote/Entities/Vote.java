package pl.razor.SocialMediaVote.Entities;

import java.util.List;

public class Vote {

    private List<String> votes;
    private String voterName;

    public Vote(){}

    Vote(List<String> votes, String voterName){
        setVotes(votes);
        setVoterName(voterName);
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVotes(List<String> votes) {
        this.votes = votes;
    }

    public List<String> getVotes() {
        return votes;
    }
}
