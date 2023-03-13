package repositories;

import models.Family;
import models.Member;

import java.util.ArrayList;

public interface IFamilyRepository {
    ArrayList<Family> get();
    boolean create(long id, ArrayList<Member> members);
    boolean addNewMember(long id, String name, int age, double salary);
    double getTotalSalary(long id);
    long getTotalDependent(long id);
}
