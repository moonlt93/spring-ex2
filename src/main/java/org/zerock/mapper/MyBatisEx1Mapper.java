package org.zerock.mapper;

import org.zerock.domain.Ex1Criteria;

public interface MyBatisEx1Mapper {
	
	public int select1(Ex1Criteria cri);
	
	public int select2(Ex1Criteria cri);
	
	public int select3(Ex1Criteria cri);
	
	public int select4(Ex1Criteria cri);
	
	public int select5(Ex1Criteria cri);
	
	// forEach - list
	public int select6(Ex1Criteria cri);
	
	// forEach - map
	public int select7(Ex1Criteria cri);
	
	// trim suffix
	public int select8(Ex1Criteria cri);
	
	// trim suffixOverrides
	public int select9(Ex1Criteria cri);
	
}






