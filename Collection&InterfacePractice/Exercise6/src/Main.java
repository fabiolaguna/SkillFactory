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
        System.out.println(club.lastBallotResults());

    }
}
