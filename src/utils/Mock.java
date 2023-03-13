package utils;

import models.Family;
import models.Member;

import java.util.ArrayList;

public class Mock {
    private static ArrayList<Family> families = new ArrayList<>();

    public static ArrayList<Family> mockFamilies() {
        Family family1 = new Family(1);
        Family family2 = new Family(2);
        Family family3 = new Family(3);
        Family family4 = new Family(4);

        ArrayList<Member> members1 = new ArrayList<>();
        ArrayList<Member> members2 = new ArrayList<>();
        ArrayList<Member> members3 = new ArrayList<>();
        ArrayList<Member> members4 = new ArrayList<>();

        members1.add(new Member("Rafael", 40, 300));
        members1.add(new Member("Marcos", 33, 600));
        members1.add(new Member("Maria", 13, 0));
        members1.add(new Member("Caio", 22, 100));

        members2.add(new Member("Ana", 21, 900));
        members2.add(new Member("Carla", 4, 0));
        members2.add(new Member("Pedro", 22, 600));
        members2.add(new Member("Gabriela", 2, 0));


        members3.add(new Member("Augusto", 33, 0));
        members3.add(new Member("Bruna", 32, 0));
        members3.add(new Member("Thiago", 18, 0));


        members4.add(new Member("Maria", 41, 1200));
        members4.add(new Member("Marcia", 17, 0));

        family1.setMembers(members1);
        family2.setMembers(members2);
        family3.setMembers(members3);
        family4.setMembers(members4);

        Mock.families.add(family1);
        Mock.families.add(family2);
        Mock.families.add(family3);
        Mock.families.add(family4);

        return families;
    }
}
