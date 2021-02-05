package org.zerock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.CommentVO;
import org.zerock.mapper.CommentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentServiceTests {

//	@Setter(onMethod_ = {@Autowired, @Qualifier("commentServiceImple"))
	private CommentService service;
	
	@Autowired
	@Qualifier("commentServiceImpl")
	public void setService(CommentService service) {
		this.service = service;
	}
	
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	
	@Test
	public void testRegister() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("새로 작성하는 내용");
		comment.setWriter("newbie");
		
		int before = mapper.getList().size();
		
		service.register(comment);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
	}
	
	
	@Test
	public void testGetList() {
		List<CommentVO> list = service.getList();
		
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
	}
	
	
	@Test
	public void testGet() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("새로 작성하는 내용");
		comment.setWriter("newbie");
		
		service.register(comment);

		CommentVO vo = service.get(comment.getCno());
		
		assertNotNull(vo);
		assertEquals(vo.getCno(), comment.getCno());
		assertEquals(vo.getContent(), comment.getContent());
		
	}
	
	
	@Test
	public void testDelete() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("새로 작성하는 내용");
		comment.setWriter("newbie");
		
		service.register(comment);
		
		assertTrue(service.remove(comment.getCno()));
	}
	
	
	@Test
	public void testUpdate() {
		CommentVO comment = new CommentVO();
		comment.setBno(1L);
		comment.setContent("새로 작성하는 내용");
		comment.setWriter("newbie");
		
		service.register(comment);
		
		comment.setContent("수정된 내용");
		
		assertTrue(service.modify(comment));
		
		CommentVO up2 = service.get(comment.getCno());
		
		assertEquals("수정된 내용", up2.getContent());
		
		
	}
	

}
