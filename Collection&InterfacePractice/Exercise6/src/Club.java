import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class Club {

    List<ClubMember> members;
    List<Vote> votes;

    public Club(){
        members = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public void addMember(ClubMember member){
        members.add(member);
    }

    public boolean removeMember(ClubMember member){
        return members.remove(member);
    }

    public void votation(){

        votes.clear(); //Para borrar los votos de anteriores votaciones
        Random random = new Random();
        ClubMember votedMember = null;

        this.members = members.stream().distinct().collect(Collectors.toList());
        // Eliminar miembros repetidos y evitar que voten dos veces o mas

        for (ClubMember member : members){
            do {
                votedMember = members.get(random.nextInt(members.size()));
            } while (votedMember.equals(member)); // Evita que se vote a si mismo

            votes.add(new Vote(member.getId(), votedMember.getId()));
        }
    }


    public Map<UUID,Integer> lastBallotResults(){

        Map<UUID,Integer> lastVotes = new HashMap<>();
        int votesAmount;

        for (int i=0 ; i<members.size() ; i++){

            votesAmount = 0;
            for (Vote v : votes){
                if (v.getIdVoted() == members.get(i).getId()){
                    votesAmount++;
                }
            }

            lastVotes.put(members.get(i).getId(), votesAmount);
        }

        return lastVotes;
    }

    public String lastBallotVotesList(){

        return votes.stream()
                .map(Objects::toString)
                .reduce("", (a,vote) -> a + vote + "\n");
    }

    public String membersList(){

        String list = "";
        Collections.sort(members, ClubMember::compareTo);

        for (ClubMember member : members){
            list += member.toString() + "\n";
        }
        return list;
    }
}
