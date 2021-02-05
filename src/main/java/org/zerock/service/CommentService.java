package org.zerock.service;

import java.util.List;

import org.zerock.domain.CommentVO;

public interface CommentService {

	void register(CommentVO comment);

	List<CommentVO> getList();

	CommentVO get(Long cno);

	boolean remove(Long cno);

	boolean modify(CommentVO comment);

}
