package repositories;

import models.Family;
import models.Member;
import utils.Mock;

import java.util.ArrayList;
import java.util.Optional;

public class FamilyRepository implements IFamilyRepository {
    ArrayList<Family> families = Mock.mockFamilies();
    public ArrayList<Family> get() {
        return this.families;
    }

    @Override
    public boolean create(long id, ArrayList<Member> members) {
        boolean hasMinMembers = members.size() >= 2;
        boolean hasDependent = members.stream().anyMatch((x) -> x.getAge() < 18);

        if (hasMinMembers && hasDependent) {
            Optional<Family> family = families.stream().filter(x -> x.getId() == id).findFirst();

            family.ifPresent(value -> value.getMembers().addAll(members));
        } else {
            return false;
        }

        return true;
    }

    @Override
    public boolean addNewMember(long id, String name, int age, double salary) {
        if (name == null) return false;

        Optional<Family> family = families.stream().filter(x -> x.getId() == id).findFirst();

        if (family.isPresent()) {
            Member newMember = new Member(name, age);
            newMember.setSalary(salary);
            family.get().getMembers().add(newMember);

            return true;
        }

        return false;
    }

    @Override
    public double getTotalSalary(long id) {
        Optional<Family> family = families.stream().filter(x -> x.getId() == id).findFirst();

        return family.map(value -> value.getMembers().stream().mapToDouble(Member::getSalary).sum()).orElse(0.0);
    }

    @Override
    public long getTotalDependent(long id) {
        Optional<Family> family = families.stream().filter(x -> x.getId() == id).findFirst();

        return family.map(value -> value.getMembers().stream().filter((x) -> x.getAge() < 18).count()).orElse(0L);
    }
}
