import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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


    public String lastBallotResults(){

        String results = "";
        int votesAmount;

        for (int i=0 ; i<members.size() ; i++){

            votesAmount = 0;
            for (Vote v : votes){
                if (v.getIdVoted() == members.get(i).getId()){
                    votesAmount++;
                }
            }

            results += "Member id: " + members.get(i).getId() + "\nName: " + members.get(i).getName() + "\nVotes: " + votesAmount + "\n\n";
        }

        return results;
    }

    public String lastBallotVotesList(){

        String list = "";
        for (Vote v : votes){
            list += v.toString() + "\n";
        }

        return list;
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
