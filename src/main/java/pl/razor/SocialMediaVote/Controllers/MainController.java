package pl.razor.SocialMediaVote.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.razor.SocialMediaVote.Entities.Participant;
import pl.razor.SocialMediaVote.Entities.Vote;
import pl.razor.SocialMediaVote.Repositories.ParticipantRepository;
import pl.razor.SocialMediaVote.Repositories.VoteRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    // Facebook connection hooks:
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    // Vote candidates list:
    List<Participant> participants;

    public MainController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;

        //  Fill list with test candidates:
        participants = createMockParticipantList();
    }

    @GetMapping
    @RequestMapping("/")
    public String helloFacebook(Model model) {

        // Condition redirect:
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        // Get all participants
        participants = participantRepository.findAll();

        // Get names of groups user belongs to:
        List<GroupMembership> listGroup=facebook.groupOperations().getMemberships();
        List<String> groupNames = new ArrayList<>();

        for(GroupMembership gm : listGroup){
            groupNames.add(gm.getName());
        }

        // Check if user belongs to wanted group:
        Boolean userIsInGroup = groupNames.contains("Informatyka PRz 2016/17");

        // Create objects for model:
        //--    Create vote object to handle results
        Vote vote = new Vote();

        //--    Create facebook user object containing wanted info fields
        String [] fields = { "id", "name", "first_name"};
        User user = facebook.fetchObject("me", User.class, fields);

        //--    Separate fields from user object
        String name=user.getName();
        String firstName=user.getFirstName();

        // Check if user already voted:
        Iterable<Vote> votes = voteRepository.findAll();
        for(Vote v : votes){
            if(v.getVoterName().equals(user.getName()))
                return "alreadyVoted";
        }

        //--    Create feed object
        PagedList<Post> feed = facebook.feedOperations().getFeed();

        // Set model attributes:
        model.addAttribute("name",name );
        model.addAttribute("firstName",firstName);
        model.addAttribute("facebookProfile", user);
        model.addAttribute("userIsInGroup",userIsInGroup);
        model.addAttribute("participants",participants);
        model.addAttribute("vote",vote);
        model.addAttribute("feed", feed);

        return "main";
    }

    //------------- TEST METHODS -------------
    private List<Participant> createMockParticipantList(){
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("Razor",0));
        participants.add(new Participant("Lobo",0));
        participants.add(new Participant("Krzy",0));
        participants.add(new Participant("Marcin", 0));
        return participants;
    }
}
