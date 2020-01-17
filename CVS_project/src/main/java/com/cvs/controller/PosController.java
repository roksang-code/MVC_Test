package com.cvs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cvs.model.Md_infoVO;
import com.cvs.model.Pos_boardVO;
import com.cvs.service.PosService;

@Controller
@RequestMapping("/pos")
public class PosController {
	
	@Autowired
	private PosService pservice;
	private static final Logger logger = LoggerFactory.getLogger(PosController.class);

	
	@RequestMapping(value = "/posPayment", method = RequestMethod.GET)//pos화면
	public String posGet() throws Exception {

		logger.info("pos get...");

		return "pos/posPayment";
	}
	


	@ResponseBody
	@RequestMapping(value = "/posList", method = RequestMethod.GET)//상품리스트
	public Md_infoVO posList(@RequestParam int barcode_no,Md_infoVO mdvo) throws Exception{
		
		//list = pservice.inputMdlist(md_no);
		mdvo = pservice.inputMdlist(barcode_no);
		logger.info("entity="+mdvo);
		logger.info("barcode_no = "+barcode_no);
	
		return mdvo;
	}
	

	@RequestMapping(value = "/posPaymentList", method = RequestMethod.GET)//판매내역
	public String PaymentList() throws Exception {

		logger.info("PaymentList get...");

		return "pos/posPaymentList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/Payment", method = RequestMethod.POST)//결제
	public String Payment(@RequestBody Pos_boardVO pvo) throws Exception {

		pservice.Payment(pvo);
		logger.info("Payment post...");
		logger.info("getBarcode_no"+pvo.getBarcode_no());
		logger.info("getMd_ea"+	pvo.getMd_ea());

		
		
		return "pos/posPayment";
	}
	
	

	
	
	
	
}
