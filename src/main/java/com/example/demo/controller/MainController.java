package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.AccountCompanyDto;
import com.example.demo.dto.AuthUserDto;
import com.example.demo.dto.ExportingCargoDto;
import com.example.demo.dto.ExportingExportDto;
import com.example.demo.dto.LoginUserDetails;
import com.example.demo.dto.MailDto;
import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.entity.ExportingProductEntity;
import com.example.demo.service.MainService;
import com.example.demo.utill.PageNavigator;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {
	@Value("${user.board.pageLimit}") // 이건 한페이지의 게시글 수 
	private int pageLimit ; // 한페이지에 보여줄 글의 개수
	private final MainService service;
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	
	
	@GetMapping("/tracking")
	public String return1() {
		return "mypage/cargoDetail";
	}
	
	
	@GetMapping({"","/"})
	public String index() {
		log.info("정보가 잘 싱핻?");
		return "index";
	}
//	
//	@GetMapping({"/dong/ofinfoNew"})
//	public String index3(Model model,
//			@PageableDefault(page=1) Pageable pageable,
//			@RequestParam(name="searchItem",defaultValue="buyerCompanyName") String searchItem,
//			@RequestParam(name="searchWord",defaultValue="") String searchWord,
//			@AuthenticationPrincipal LoginUserDetails loginUser
//			) {
//		log.info("검색단어=>{}",searchWord);
//		log.info("선정 카테고리 =>{}",searchItem);
//		String id = loginUser.getUsername();
//		Page<ExportingExportDto> list = service.selectAll(id,pageable,searchItem,searchWord);
//		int totalPages= list.getTotalPages() ; // DB에서 받아온 정보에서 추출
//		log.info("모든페이지의 수_{}",totalPages);
//		log.info("현재 그룹_{}",list.getNumberOfElements());
//		int page = pageable.getPageNumber() ; // 사용자가 요청한 정보에서 추출
//		PageNavigator navi = new PageNavigator(pageLimit,page,totalPages);
//		model.addAttribute("export",list);
//		model.addAttribute("list",list);
//		model.addAttribute("searchItem",searchItem);
//		model.addAttribute("searchWord",searchWord);
//		model.addAttribute("navi",navi);
//		return "dong/ofinfoNew";
////		return "dong/register";
//	}
	
	/**
	 * 
	 * @param model
	 * @param pageable
	 * @param searchItem
	 * @param searchWord
	 * @param exportCargoDto
	 * @param exportId
	 * @param userId
	 * @param loginUser
	 * @return
	 * 	@RequestParam(name="exportId") Long exportId,
			@RequestParam(name="userId") String userId,
	 */

	@PostMapping({"/dong/ofinfoNew"})
	public String index2(Model model,
			@RequestParam(name="exportId") Long exportId,
			@RequestParam(name="hscode") String hscode,
			@RequestParam(name="quantity") int quantity,
			@RequestParam(name="pricePerunit") double pricePerunit,
			@RequestParam(name="description") String description,
			@ModelAttribute ExportingCargoDto exportCargoDto,
			@AuthenticationPrincipal LoginUserDetails loginUser
			) {
//		service.saveCargoInfo(exportCargoDto, exportId);
		String id = loginUser.getUsername();
		AuthUserDto user = service.findUser(id);
		AuthUserEntity user1 = AuthUserEntity.ToEntity(user);
		ExportingExportDto export = service.findExportingEntity(id, exportId);
		ExportingExportEntity export1 = ExportingExportEntity.ToEntity(export, user1);
		service.saveCargoInfo(exportCargoDto, exportId);
		ExportingProductEntity product = new ExportingProductEntity();
		product.setDescription(description);
		product.setExportId(export1);
		product.setPricePerUnit(pricePerunit);
		product.setQuantity(quantity);
		product.setHscode(hscode);
		service.saveProduct(exportId, product);
//		model.addAttribute("userId",userId);
	
		return "dong/success2";
//		return "dong/register";
	}
	
	// 유저 정보를 받아서 저장한 후 계약정보를 입력하는 란으로 이동시킨다
	@GetMapping("/dong/start")
	public String registerUser(
			@ModelAttribute AuthUserDto userDto,
			Model model) {
		// 여기서 저장을 하고 유저 아이디를 반환하다

		return "dong/start";
	}
	
	
	
	/**
	 * 사용자로부터 계약정보를 입력받아 이후 화물정보를 입력받는 란으로 이동시킨다
	 * @param exportDto
	 * @param userId
	 * @param model
	 * @return
	 * @ModelAttribute ExportingProductEntity product
	 * @RequestParam(name="exportId") Long exportId,
	 */
	
	@PostMapping("/dong/cargoInfo")
	public String getExportInfor(
			@ModelAttribute ExportingExportDto export,
			@AuthenticationPrincipal LoginUserDetails loginUser,Model model
			) {
		//TODO: process POST request
		String userId = loginUser.getUsername();
		Long exportId = service.saveExporting(export, userId);
		
		log.info("getExportInfor_ 정보 {}" , userId);
//		service.saveProduct(exportId, product);  나중에 풀어야한다 주석처리 풀자
		model.addAttribute("exportId",exportId);
		model.addAttribute("userId",userId); // 회원가입한 사용자의 정보를 알수 있게한다
		return "dong/cargoInfo";
	}

	
	/**
	 * 여기서는 한번 파일 보기 버튼을 누르고 다시 파일들이 주르륵 나오는 파일작성 시작페이지로 이동시키는 것이다
	 * @param id
	 * @param model
	 * @param usertId
	 * @return
	 */
	@GetMapping("/dong/ofInfo")
	public String retunofinfonew(@RequestParam("exportId") Long exportId,Model model,
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@PageableDefault(page=1) Pageable pageable,
			@RequestParam(name="searchItem",defaultValue="buyerCompanyName") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord) {
		String id = loginUser.getUsername();
		Page<ExportingExportDto> export = service.selectAll(id,pageable,searchItem,searchWord);
		model.addAttribute("exportId",exportId);
		model.addAttribute("export",export);
		int totalPages= export.getTotalPages() ; // DB에서 받아온 정보에서 추출
		
		int page = pageable.getPageNumber() ; // 사용자가 요청한 정보에서 추출
		PageNavigator navi = new PageNavigator(pageLimit,page,totalPages);
		model.addAttribute("list",export);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("navi",navi);
		return "dong/ofInfoNew";
		
	}
	
	
	@GetMapping("/dong/fileDetail")
	public String getFileDetail(@RequestParam("id") Long id, Model model,@AuthenticationPrincipal LoginUserDetails loginUser) {
		String userId = loginUser.getUsername();
		ExportingExportDto export = service.findExportingEntity(userId, id);
		ExportingCargoDto cargo = service.findExportingCargo(id);
		AccountCompanyDto company = service.findCompany(userId);
		AuthUserDto user = service.findUser(userId);
		log.info("FielDetail_{}",export.getBuyerCompanyAddress());
		model.addAttribute("cargo",cargo);
		model.addAttribute("export",export);
		model.addAttribute("company",company);
		model.addAttribute("user",user);
		
		LocalDate date = export.getContractDate();
		log.info("날짜 정보_{}",date);
		String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    model.addAttribute("now", now); // contractDate를 모델에 추가
		return "dong/fileDetail";
		
	}
	
	
	
	
	//----------------------------------------------------------------------------------------- 이 위는 전부 페이지 이동
	
	/**
	 * 여기서는 사용자가 자신의 견적서 내용의 변경을 허용한다
	 * @param exportId
	 * @param userId
	 * @param model
	 * @return
	 */
	@GetMapping("/dong/update")
	public String modifyQuote(
			@RequestParam("exportId") Long exportId
			,@AuthenticationPrincipal LoginUserDetails loginUser,Model model) {
		String userId = loginUser.getUsername();
		ExportingExportDto exportDto = service.findExportingEntity(userId, exportId);
		model.addAttribute("exportDto",exportDto);
		model.addAttribute("exportId",exportId);
		model.addAttribute("userId",userId); // 이건 나중에 지워야한다

		return "dong/modify";
	}
	
	/**
	 * 여기서는 수출계약서의 수정내용을 저장한 후 화물 정보 수정 페이지를 보여주는 컨트롤러
	 * @return
	 */
	@PostMapping("/dong/modifyExport/{exportId}/{userId}")
	public String updateCargoInfo(
			@ModelAttribute ExportingExportDto exportDto,
			Model model,
			@PathVariable("exportId") Long exportId,
			@PathVariable("userId") String userId
			) {
		ExportingCargoDto cargoDto = service.findExportingCargo(exportId);
		log.info("cargoDTo 정보 ==>{}",cargoDto.toString());
		log.info("cargoDTo 가로 정보 ==>{}",cargoDto.getLength());
		service.modifyExportingSave(exportDto, exportId); // 수정된 정보
		model.addAttribute("cargoDto",cargoDto);
		model.addAttribute("exportId",exportId);
		model.addAttribute("userId",userId);
		return "dong/modifyCargo";
	}
	
	
	/**
	 * 여기서는 화물 수정정보 페이지에서 클릭하면 수정한 정보에따라 기존에 입력햇던 화물의 정보를 수정하는
	 * 컨트롤러이다
	 */
	@PostMapping("/dong/modifyCargo/{exportId}/{userId}")
	public String modifyCargoInfo(
			@ModelAttribute ExportingCargoDto cargoDto,Model model,
			@PathVariable("exportId") Long exportId,
			@PathVariable("userId") String userId,
			@AuthenticationPrincipal LoginUserDetails loginUser,
			@PageableDefault(page=1) Pageable pageable,
			@RequestParam(name="searchItem",defaultValue="buyerCompanyName") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord
			) {
		// 여기서 유저아이디가 필요하다
		log.info("exportId_ {} 달력처리위",exportId);
		service.modifyCargoSave(cargoDto,exportId);
		String id = loginUser.getUsername();
		Page<ExportingExportDto> export =service.selectAll(id,pageable,searchItem,searchWord);
		model.addAttribute("exportId",exportId);
		model.addAttribute("export",export);
		int totalPages= export.getTotalPages() ; // DB에서 받아온 정보에서 추출
		
		int page = pageable.getPageNumber() ; // 사용자가 요청한 정보에서 추출
		PageNavigator navi = new PageNavigator(pageLimit,page,totalPages);
		model.addAttribute("list",export);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("navi",navi);

		return "dong/ofInfoNew";
		
	}
	
	@GetMapping("/dong/delete")
	public String deleteExportEntity(
			@RequestParam("exportId") Long exportId ,Model model
			,@RequestParam("userId") String userId ,
			@PageableDefault(page=1) Pageable pageable,
			@RequestParam(name="searchItem",defaultValue="buyerCompanyName") String searchItem,
			@RequestParam(name="searchWord",defaultValue="") String searchWord,
			@AuthenticationPrincipal LoginUserDetails loginUser) {
		service.deleteCargoEntity(exportId);
		service.deleteExportingEntity(exportId);
		String id = loginUser.getUsername();
		Page<ExportingExportDto> export = service.selectAll(id,pageable,searchItem,searchWord);
		model.addAttribute("exportId",exportId);
		model.addAttribute("userId",userId);
		model.addAttribute("export",export);
		int totalPages= export.getTotalPages() ; // DB에서 받아온 정보에서 추출
		
		int page = pageable.getPageNumber() ; // 사용자가 요청한 정보에서 추출
		PageNavigator navi = new PageNavigator(pageLimit,page,totalPages);
		model.addAttribute("list",export);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("navi",navi);

		return "dong/ofInfoNew";
	}
// --------------------------------------------------------------------------------------------------------
	
	/**
	 * 달력 처리
	 * @return
	 */
	@ResponseBody 
	@GetMapping("/calendar/getSpecialDays")
	public List<LocalDate> getCalculate() {
		log.info("이 프로그램이 작동중이다");
		List<LocalDate> days= new ArrayList<>();
		days.add(LocalDate.now());
		days.add(LocalDate.of(2024, 10, 15));
		days.add(LocalDate.of(2024, 11, 18));
		days.add(LocalDate.of(2024, 12, 25));
		return days;
	}
	
	@GetMapping("/dong/fileWrite")
	public String fileWrite(
			@RequestParam("exportId") Long exportId,
			@AuthenticationPrincipal LoginUserDetails loginUser,
			Model model
			)  {
		String userId = loginUser.getUsername();
		// 파일이 저장된 경로
//		String  directoryPath =service.writeShipmentRequest2(exportId,userId);
		AuthUserDto user = service.findUser(userId);
		AccountCompanyDto company = service.findCompany(userId);
		ExportingExportDto export = service.findExportingEntity(userId, exportId);
		ExportingCargoDto cargo = service.findExportingCargo(exportId);
		
		Map<String,String> data = new HashMap<>();
		data.put("{sender}",company.getName()+"1");
		data.put("{send}", String.valueOf(LocalDate.now())+"1");
		data.put("{email}", user.getEmail()+"1");
		data.put("{cargoname}", cargo.getName()+"1");
		data.put("{loadingPort}", export.getPlaceOfLoading()+"1");
		data.put("{unloadingPort}", export.getPlaceOfUnloading()+"1");
		data.put("{cargoWeight}", Double.toString(cargo.getWeight())+"1");
		data.put("{cargoHeight}", Double.toString(cargo.getHeight())+"1");
		data.put("{cargoWidth}", Double.toString(cargo.getWidth())+"1");
		data.put("{containerType}", cargo.getContainerType()+"1");
		data.put("{address}",company.getAddress()+"1");
		data.put("{isDangerous}", cargo.getIsDangerous()+"1");
		data.put("{date}",String.valueOf(export.getContractDate())+"1");
		model.addAttribute("exportId",exportId);
		model.addAttribute("username",userId);
		try {	
			String directoryPath = service.generateInvoice(data);
			model.addAttribute("directoryPath",directoryPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		model.addAttribute("directoryPath",directoryPath);
		
		return "dong/ship";
	}
	

	/**
	 * 메일 전송처리가 오면 이걸로 처리한다
	 * @return
	 */
	@PostMapping("/send")
	public String sendMail(
			@ModelAttribute MailDto mailDto,
			@RequestParam("directoryPath") String directoryPath) {
			log.info("메일에서 보내는 파일 경로_{}",directoryPath);
				service.mailSend(mailDto, directoryPath);
		
				return "/dong/success" ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}