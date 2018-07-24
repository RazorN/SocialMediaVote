package pl.razor.SocialMediaVote.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.razor.SocialMediaVote.Entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    Participant findByName(String s);
}
