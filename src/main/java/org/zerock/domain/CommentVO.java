package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVO {
	private Long cno;
	private Long bno;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
