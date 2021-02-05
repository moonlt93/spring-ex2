package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxService {
	
	@Setter(onMethod_=@Autowired)
	private Sample1Mapper mapper1;
	@Setter(onMethod_=@Autowired)
	private Sample2mapper mapper2;
	
	@Transactional //여러 데이터처리 어노테이션
	public void addData(String value) {
		mapper1.insertCol1(value);//500바이트 ok
		mapper2.insertCol2(value);//50byte fail
		
		
	}
	

}
