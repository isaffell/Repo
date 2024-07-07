import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	GradeBook gb1;
	GradeBook gb2;

	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		gb1.addScore(10);
		gb1.addScore(20);
		gb1.addScore(30);
		gb1.addScore(40);
		
		gb2.addScore(10);
		gb2.addScore(20);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	@Test
	void addScore() {
		assertTrue(gb1.toString().equals("10.0 20.0 30.0 40.0"));
        assertTrue(gb2.toString().equals("10.0 20.0"));
        assertEquals(4, gb1.getScoreSize());
        assertEquals(2, gb2.getScoreSize());
	}
	
	@Test
	void sum() {
		assertTrue(100 == gb1.sum());
		assertTrue(30 == gb2.sum());
		
	}
	
	@Test
	void minimum() {
		assertTrue(10 == gb1.minimum());
		assertTrue(10 == gb2.minimum());
	}
	
	@Test
	void finalScore() {
		
		assertTrue(90 == gb1.finalScore());
		assertTrue(20 == gb2.finalScore());
	}

}
