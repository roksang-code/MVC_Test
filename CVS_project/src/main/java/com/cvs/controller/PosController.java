package com.cvs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cvs.model.Auto_incrementVO;
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
	
	@RequestMapping(value = "/posPaymentList", method = RequestMethod.GET)//매출 리스트 화면
	public String posPaymentListGet() throws Exception {

		logger.info("posPaymentList get...");
		
		return "pos/posPaymentList";
	}
	
	@RequestMapping(value = "/posPaymentList", method = RequestMethod.POST)//매출 리스트 화면
	public void posPaymentListPost(@RequestBody Pos_boardVO pvo, Model model) throws Exception {

		logger.info("posPaymentList post...");

		model.addAttribute("PaymentList", pservice.PaymentList(pvo)); 
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
	

	@RequestMapping(value = "/posPaymentList1", method = RequestMethod.GET)//판매내역
	public void posPaymentList(Pos_boardVO pvo, Model model) throws Exception {
			
			  
		//  model.addAttribute("list", pservice.posPaymentList(pvo)); 

			 
			  
		logger.info("PaymentList get...");

	}
	
	@ResponseBody
	@RequestMapping(value = "/Payment", method = RequestMethod.POST)//결제
	public void Payment(@RequestBody Pos_boardVO pvo) throws Exception {

		pservice.Payment(pvo);
		logger.info("Payment post...");
		logger.info("getBarcode_no"+pvo.getBarcode_no());
		logger.info("getMd_ea"+	pvo.getMd_ea());

		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/Auto_increment", method = RequestMethod.POST)//결제
	public String Auto_increment(@RequestBody Auto_incrementVO aivo) throws Exception {
	
		if(aivo.getEmp_no()!=1) {
			aivo.setEmp_no(0);		
		}else if(aivo.getList_no()!=1) {
			aivo.setList_no(0);		
		}else if(aivo.getMember_no()!=1) {
			aivo.setMember_no(0);		
		}else if(aivo.getStore_no()!=1) {
			aivo.setStore_no(0);		
		}else if(aivo.getTrade_no()!=1) {
			aivo.setTrade_no(0);		
		}
		
		
		pservice.increment(aivo);
		logger.info("increment post...");
		logger.info("getList_no = "+aivo.getList_no());
		logger.info("aivo = "+aivo);

		return "pos/posPayment";

	}
	
}
