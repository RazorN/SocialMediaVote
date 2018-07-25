package pl.razor.SocialMediaVote.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.razor.SocialMediaVote.Entities.Participant;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    Participant findByName(String s);
    List<Participant> findAll();
}
