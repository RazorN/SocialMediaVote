package pl.razor.SocialMediaVote.Controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.razor.SocialMediaVote.Entities.Vote;

import java.util.Iterator;
import java.util.Objects;

@Controller
public class VoteController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    VoteController(Facebook facebook, ConnectionRepository connectionRepository){
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    // Getting vote results:
    @PostMapping
    @RequestMapping("/vote")
    public String getVotes(@ModelAttribute("vote") Vote vote, Model model){

        // Condition redirect:
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/";
        }

        // Removing null values from votes list:
        vote.getVotes().removeIf(Objects::isNull);

        // Create feed object:
        PagedList<Post> feed = facebook.feedOperations().getFeed();

        // Set model attributes:
        model.addAttribute("votes",vote.getVotes());
        model.addAttribute("feed", feed);

        return "VoteResult";
    }
}
