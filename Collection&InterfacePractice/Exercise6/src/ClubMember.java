import java.util.Objects;
import java.util.UUID;

public class ClubMember implements Comparable<ClubMember> {

    private UUID id;
    private String name;
    private String phone;
    private Integer age;

    public ClubMember(String name, String phone, Integer age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ClubMember member) {
        return this.getName().compareTo(member.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMember that = (ClubMember) o;
        return (Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public String toString() {
        return "Member: " + id + "\nName: " + name + "\nPhone: " + phone + "\nAge: " + age + "\n";
    }

}
