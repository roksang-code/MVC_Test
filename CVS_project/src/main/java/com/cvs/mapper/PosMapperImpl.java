package com.cvs.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cvs.model.Auto_incrementVO;
import com.cvs.model.Md_infoVO;
import com.cvs.model.Pos_boardVO;

@Repository
public class PosMapperImpl implements PosMapper{

	@Autowired
	private SqlSession session;
	private static String namespace = "com.cvs.mapper.PosMapper";

	
	@Override
	public Md_infoVO inputMdlist(int barcode_no) throws Exception {
		
		Md_infoVO mdlist = session.selectOne(namespace+".inputMdlist",barcode_no);
 
		
		return mdlist;
	}


	@Override
	public void Payment(Pos_boardVO pvo) throws Exception {
		
		session.insert(namespace+".Payment",pvo);
		
	}


	@Override
	public List<Pos_boardVO> PaymentList(Pos_boardVO pvo) throws Exception {
		
		List<Pos_boardVO> PaymentList = session.selectList(namespace+".PaymentList");
		
		return PaymentList;
	}


	@Override
	public void increment(Auto_incrementVO aivo) throws Exception {
		session.insert(namespace+".increment",aivo);
		
	}

}
