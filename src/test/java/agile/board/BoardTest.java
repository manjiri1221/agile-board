package agile.board;



import static org.junit.Assert.assertTrue;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.agile.board.Application;
import com.agile.board.entity.Board;
import com.agile.board.service.BoardService;
/**
 * Test class for board
 * @author manjirilakhote
 *
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class BoardTest {

	@Autowired
	BoardService boardService;
	
	// Test to create a board with given params
	@Test
	public void createEmptyBoardTest() throws Exception {
		
		String name = "board1";
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		Board board = boardService.createBoard(name,createdBy).block();
		assertTrue(name.equals(board.getName()));
		
	}
	// Test with null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithNullNameTest() throws Exception {
		
		String name = null;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		boardService.createBoard(name,createdBy).block();
		
	}
	
	// Test with empty name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithEmptyNameTest() throws Exception {
		
		String name = "";
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		boardService.createBoard(name,createdBy).block();
		
	}
	
	
	// Test with null createdBy, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithNullCreatedByTest() throws Exception {
		
		String name = "board1";
		boardService.createBoard(name,null).block();
		
	}
	
	// Test without name,createdBy, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithoutNameAndCreatedByTest() throws Exception {
		
		boardService.createBoard(null,null).block();
		
	}
	//Q1 output the board as a JSON message
	
	@Test
	public void listABoardWithColumnsAndCardsTest() {
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		boolean assertion = true;
		try {
			boardService.listABoardWithColumnsAndCards(boardId).collectList().block();
		}catch(Exception e) {
			assertion = false;
		}
		assertTrue(assertion);
	}

}
