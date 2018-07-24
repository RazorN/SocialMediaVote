package pl.razor.SocialMediaVote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.razor.SocialMediaVote.Entities.Participant;
import pl.razor.SocialMediaVote.Repositories.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class SocialMediaVoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaVoteApplication.class, args);
	}
}
