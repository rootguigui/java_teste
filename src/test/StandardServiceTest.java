package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.StandardService;
import utils.Mock;

import static junit.framework.Assert.assertEquals;

public class StandardServiceTest {
    StandardService standardService;
    @BeforeEach
    public void setUp() {
        this.standardService = new StandardService();
    }

    @Test
    @DisplayName("Should be return list of family")
    public void returnListOfFamily() {
        assertEquals(Mock.mockFamilies(), this.standardService.calculateAndOrderByPoints());
    }
}
