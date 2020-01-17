package com.cvs.mapper;

import com.cvs.model.Md_infoVO;
import com.cvs.model.Pos_boardVO;

public interface PosMapper {
	public Md_infoVO inputMdlist(int barcode_no) throws Exception;
	
	public void Payment(Pos_boardVO pvo) throws Exception;

}
