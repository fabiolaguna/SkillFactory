import java.util.UUID;

public class Vote {

    private UUID idVote;
    private UUID idVoter;
    private UUID idVoted;

    public Vote(UUID idVoter, UUID idVoted) {
        idVote = UUID.randomUUID();
        this.idVoter = idVoter;
        this.idVoted = idVoted;
    }

    public UUID getIdVoter() {
        return idVoter;
    }

    public UUID getIdVoted() {
        return idVoted;
    }

    @Override
    public String toString() {
        return "Vote identification: " + idVote + "\nVoting member identification: " + idVoter
                + "\nVoted member identification: " + idVoted + "\n";
    }

}
