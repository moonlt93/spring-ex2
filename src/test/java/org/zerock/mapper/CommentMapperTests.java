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
import org.zerock.domain.CommentVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;

	@Test
	public void testExist() {
		assertNotNull(mapper);
	}

	@Test
	public void testGetList() {
		List<CommentVO> list = mapper.getList();
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void testInsert() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("new comment");
		comment.setWriter("newbie");
		
		int before = mapper.getList().size();
		
		mapper.insert(comment);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
	}
	
	
	@Test
	public void testInsertSelectKey() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("new comment");
		comment.setWriter("newbie");
		
		int before = mapper.getList().size();
		
		mapper.insertSelectKey(comment);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
	}
	
	@Test
	public void testRead() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("new comment");
		comment.setWriter("newbie");
		
		mapper.insertSelectKey(comment);
		
		CommentVO com = mapper.read(comment.getCno());
		assertNotNull(com);
		assertNotEquals(com.getCno(), new Long(0));
	}
	
	@Test
	public void testDelete() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("new comment");
		comment.setWriter("newbie");
		
		mapper.insertSelectKey(comment);
		
		int before = mapper.getList().size();
		
		int cnt = mapper.delete(comment.getCno());
		
		int after = mapper.getList().size();
		
		assertEquals(cnt, 1);
		assertEquals(before - 1, after);
	}
	
	@Test
	public void testUpdate() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("new comment");
		comment.setWriter("newbie");
		
		mapper.insertSelectKey(comment);
		
		comment.setContent("other comment");
		
		int cnt = mapper.update(comment);
		
		assertEquals(cnt, 1);
		
		CommentVO com = mapper.read(comment.getCno());
		
		assertEquals("other comment", com.getContent());
	}
}









