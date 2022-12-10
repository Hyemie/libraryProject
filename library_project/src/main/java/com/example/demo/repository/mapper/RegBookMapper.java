package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import vo.RegBookVO;

public interface RegBookMapper {
	
	public int Reginsert(RegBookVO regbook);
	public List<RegBookVO> selectAll();
	public RegBookVO select(@Param("RNum") int RNum, @Param("RState") int RState);
	public int updateState(int RNum, int RState);
}
