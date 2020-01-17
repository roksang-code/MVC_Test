package com.cvs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvs.mapper.PosMapper;
import com.cvs.model.Md_infoVO;
import com.cvs.model.Pos_boardVO;


@Service
public class PosServiceImpl implements PosService{

	@Autowired
	PosMapper pm;
	
	@Override
	public Md_infoVO inputMdlist(int barcode_no) throws Exception {
		Md_infoVO mdlist = pm.inputMdlist(barcode_no);
 
		return mdlist;
		}

	@Override
	public void Payment(Pos_boardVO pvo) throws Exception {
		
		pm.Payment(pvo);

	 
		 		
	}

}
