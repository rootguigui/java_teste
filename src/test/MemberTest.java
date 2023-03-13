package test;

import models.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MemberTest {
    @Test
    @DisplayName("Should be return values")
    public void testAllGetterMethods(){
        Member member = new Member("Member test", 20, 300.0);

        assertAll("",
                () -> assertEquals(20, member.getAge()),
                () -> assertEquals(300.0, member.getSalary()));
    }
}
