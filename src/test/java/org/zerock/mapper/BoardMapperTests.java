package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testSearch1() {
		Criteria cri = new Criteria();
		cri.setType("T");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testSearch2() {
		Criteria cri = new Criteria();
		cri.setType("C");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testSearch3() {
		Criteria cri = new Criteria();
		cri.setType("W");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testSearch4() {
		Criteria cri = new Criteria();
		cri.setType("TC");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testSearch5() {
		Criteria cri = new Criteria();
		cri.setType("TWC");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testSearch6() {
		Criteria cri = new Criteria();
		cri.setType("TW");
		cri.setKeyword("테스트");
		
		mapper.getListWithPaging(cri);
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		
//		assertEquals(list.size(), 5);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		int before = mapper.getList().size();
		
		mapper.insert(board);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
		
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		int before = mapper.getList().size();
		
		mapper.insertSelectKey(board);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
		assertNotEquals(board.getBno(), new Long(0L));
		
	}
	
	@Test
	public void testRead() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		BoardVO readBoard = mapper.read(board.getBno());
		
		assertNotNull(readBoard);
		assertEquals(readBoard.getBno(), board.getBno());
		
	}
	
	@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		
		int before = mapper.getList().size();
		
		int cnt = mapper.delete(board.getBno());
		
		assertEquals(1, cnt);
		
		int after = mapper.getList().size();
		
		assertEquals(before-1, after);
		
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 제목");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		board.setTitle("변경된 제목");
		board.setContent("변경된 내용");
		int cnt = mapper.update(board);
		
		assertEquals(1, cnt);
		
		BoardVO updateVO = mapper.read(board.getBno());
		assertEquals("변경된 제목", updateVO.getTitle());
		assertEquals("변경된 내용", updateVO.getContent());
		
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria(1, 5);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		assertEquals(5, list.size());
		
		cri = new Criteria(1, 10);
		list = mapper.getListWithPaging(cri);
		
		assertEquals(10, list.size());
		
		cri = new Criteria(2, 5);
		list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info("번호:" + board.getBno()));
	}
}






