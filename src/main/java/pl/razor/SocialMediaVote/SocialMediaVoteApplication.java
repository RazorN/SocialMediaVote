package pl.razor.SocialMediaVote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public CommandLineRunner demo(ParticipantRepository repository) {
        return (args) -> {
            // save a couple of participants
            List<Participant> participants = new ArrayList<>();
            participants.add(new Participant("Razor", 0));
            participants.add(new Participant("Lobo", 0));
            participants.add(new Participant("Krzy", 0));
            participants.add(new Participant("Marcin", 0));
            repository.save(participants);
        };
    }
}
