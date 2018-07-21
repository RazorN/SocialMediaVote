package pl.razor.SocialMediaVote.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.razor.SocialMediaVote.Entities.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
