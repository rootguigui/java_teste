package test;

import models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repositories.FamilyRepository;
import repositories.IFamilyRepository;

import java.util.ArrayList;

import static junit.framework.Assert.*;

public class FamilyRepositoryTest {
    private IFamilyRepository repository;

    @BeforeEach
    public void setUp() {
        this.repository = new FamilyRepository();
    }
    @Test
    @DisplayName("Should be return false on create")
    public void returnSuccessfulOnCreate() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("member 1", 30, 0));
        members.add(new Member("member 2", 12, 0));

        assertTrue(this.repository.create(1, members));
    }

    @Test
    @DisplayName("Should be return false on create")
    public void returnFailureOnCreate() {
        ArrayList<Member> members = new ArrayList<>();
        assertFalse(this.repository.create(1, members));
    }

    @Test
    @DisplayName("Should be return true on add new member")
    public void returnSuccessfulOnAddNewMember() {
        boolean result = repository.addNewMember(1, "member 1", 30, 0);

        assertTrue(result);
    }

    @Test
    @DisplayName("Should be return false on add new member")
    public void returnFailureOnAddNewMember() {
        boolean result = repository.addNewMember(99, "member 1", 30, 0);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should be return false when add null name on add new member")
    public void returnFailureWhenNameIsNullOnAddNewMember() {
        boolean result = repository.addNewMember(1, null, 30, 0);

        assertFalse(result);
    }

    @Test
    @DisplayName("Should be return 0 when doesn't find id")
    public void returnZeroWhenIdIsWong() {
        assertEquals(0.0, repository.getTotalSalary(99));
    }

    @Test
    @DisplayName("Should be return value when find id")
    public void returnValueWhenIdIsCorrect() {
        assertNotSame(0.0, repository.getTotalSalary(1));
    }

    @Test
    @DisplayName("Should be return 0 dependents when doesn't find id")
    public void returnZeroDependentsWhenIdIsWong() {
        assertEquals(0L, repository.getTotalDependent(99));
    }

    @Test
    @DisplayName("Should be return value when find id")
    public void returnNumberOfDependentsWhenIdIsCorrect() {
        assertNotSame(0L, repository.getTotalDependent(1));
    }

}
