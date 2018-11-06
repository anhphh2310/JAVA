package main.java.app.kobj.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import main.java.app.kobj.*;
import org.junit.Test;
import org.junit.Assert.*;

public class BraveKnightTest {

	/*
	 * @Test public void knightShouldEmbarkOnQuest() { Quest mockQuest =
	 * mock(Quest.class); when(mockQuest.isCompleted()).thenReturn(true);
	 * BraveKnight knight = new BraveKnight(mockQuest); knight.setMotivated(true);
	 * knight.embarkOnQuest(); boolean status = knight.isQuestDone();
	 * 
	 * verify(mockQuest, times(1)).embark();
	 * assertFalse("Should be false (not completed)!", status); }
	 * 
	 * @Test public void knightQuestCompleted() { Quest mockQuest =
	 * mock(Quest.class); //brave knight, go forth! BraveKnight knight=new
	 * BraveKnight(mockQuest); knight.setMotivated(true); knight.embarkOnQuest();
	 * boolean status=knight.isQuestDone(); //Test that quest has started but not
	 * finished verify(mockQuest, times(1)).embark();
	 * assertTrue("Should be True (completed).",status); }
	 */

//	@Test
//	public void knightQuestDistance() throws QuestException {
//		Quest mockQuest = mock(Quest.class);
//		when(mockQuest.getDistance()).thenReturn(101);
//
//		BraveKnight knight = new BraveKnight(mockQuest);
//		int miles = knight.getMilesTravelled();
//
//		assertEquals(102, miles);
//
//	}

//	@Test
//	public void knightQuestLetter() {
//		Quest mockQuest = mock(Quest.class);
//		when(mockQuest.getLetter()).thenReturn('a');
//
//		BraveKnight knight = new BraveKnight(mockQuest);
//		char questLetter = knight.tellQuestLetter();
//
//		assertEquals('c', questLetter);
//	}
//
//	@Test
//	public void knightQuestName() {
//		Quest mockQuest = mock(Quest.class);
//		when(mockQuest.getName()).thenReturn("Quest for the Holy Grail");
//		BraveKnight knight = new BraveKnight(mockQuest);
//		String questName = knight.getQuestName();
//		assertTrue(("Quest for the Holy Grail").equalsIgnoreCase(questName));
//
//	}

//	@Test
//	public void knightNoQuestName() {
//		Quest mockQuest = mock(Quest.class);
//		when(mockQuest.getName()).thenReturn(null);
//		BraveKnight knight = new BraveKnight(mockQuest);
//		String questName = knight.getQuestName();
//		assertNull(questName);
//
//	}

	/*
	 * @Test public void knightGetQuest() {
	 * 
	 * Quest mockQuest = mock(Quest.class);
	 * when(mockQuest.getName()).thenReturn(null); BraveKnight knight = new
	 * BraveKnight(mockQuest); Quest myQuest = knight.getQuest();
	 * assertEquals(myQuest, mockQuest);
	 * 
	 * }
	 */

//	@Test
//	public void knightDragonQuest() {
//		DragonQuest mockQuest = mock(DragonQuest.class);
//		DragonHead dragonHead = new DragonHead("red");
//		when(mockQuest.getQuestProof()).thenReturn(dragonHead);
//		BraveKnight knight = new BraveKnight(mockQuest);
//		Object proof = knight.getQuestProof();
//		assertNotNull("Object is null", proof);
//		assertTrue((proof instanceof DragonHead));
//
//	}

	@Test
	public void knightQuestException() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		boolean success = false;
		QuestException ex = new QuestException("Thrown by Mockito");
		doThrow(ex).when(mockQuest).embark();
		try {
			BraveKnight knight = new BraveKnight(mockQuest);
			knight.setMotivated(true);
			knight.embarkOnQuest();
			success = true;
			assertFalse(success);
		} catch (Exception e) {
			assertFalse(success);
			assertTrue(e instanceof QuestException);
			assertEquals(ex.getMessage(), "Thrown by Mockito");
		}
	}

	@Test
	public void knightNoQuestException() throws QuestException {
		DragonQuest mockQuest = mock(DragonQuest.class);
		boolean success = false;
		try {
			BraveKnight knight = new BraveKnight(mockQuest);
			knight.setMotivated(true);
			knight.embarkOnQuest();
			success = true;
			assertTrue(success);
		} catch (Exception e) {
			assertTrue(success);
		}
	}

}
