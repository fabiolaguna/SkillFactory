import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Club club = new Club();

        ClubMember member1 = new ClubMember("Fabio", "12345", 25);
        ClubMember member2 = new ClubMember("Marta", "22332", 20);
        ClubMember member3 = new ClubMember("Ruben", "3210", 46);
        ClubMember member4 = new ClubMember("Carlitos", "456456", 18);
        ClubMember member5 = new ClubMember("Fede", "98765", 31);
        ClubMember member6 = new ClubMember("Carlitos", "456456", 18);

        club.addMember(member1);
        club.addMember(member2);
        club.addMember(member3);
        club.addMember(member4);
        club.addMember(member5);
        club.addMember(member6);

        club.votation();

        System.out.println(club.lastBallotVotesList());
        Map<UUID,Integer> votesAmountPerMember = club.lastBallotResults();

        Iterator<Map.Entry<UUID,Integer>> entries = votesAmountPerMember.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<UUID,Integer> entry = entries.next();
            System.out.println("MEMBER ID: " + entry.getKey() + "\nVOTES: " + entry.getValue().toString() + "\n\n");
        }

    }
}
