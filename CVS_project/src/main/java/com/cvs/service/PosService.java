package com.cvs.service;

import java.util.List;

import com.cvs.model.Auto_incrementVO;
import com.cvs.model.Md_infoVO;
import com.cvs.model.Pos_boardVO;

public interface PosService {
	public Md_infoVO inputMdlist(int barcode_no) throws Exception;

	public void Payment(Pos_boardVO pvo) throws Exception;

	public List<Pos_boardVO>  PaymentList(Pos_boardVO pvo) throws Exception;

	public void increment(Auto_incrementVO aivo) throws Exception;

}
