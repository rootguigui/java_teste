package test;

import models.Family;
import models.Member;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;

public class FamilyTest extends TestCase {
    Family family;

    @BeforeEach
    public void setUp() {
        this.family = new Family(1);
    }

    @Test
    @DisplayName("Should be return true with the members that create new family are corrects.")
    public void testCreateSuccess() {
        ArrayList<Member> members = new ArrayList<>();
        members.add( new Member("member 1", 20, 0));
        members.add(new Member("member 2", 17, 0));

        assertTrue(this.family.getMembers().addAll(members));
    }

    @Test
    @DisplayName("Should be return values")
    public void testGroupAssertions() {
        this.family = new Family(1);

        assertAll("list of members, points, total salary, number of dependents",
                () -> assertEquals(new ArrayList<Member>(), this.family.getMembers()),
                () -> assertEquals(0, this.family.getPoints())
        );
    }
}
