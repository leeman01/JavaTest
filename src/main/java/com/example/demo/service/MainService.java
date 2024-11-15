package com.example.demo.service;

import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.ParagraphFormat;
//import com.aspose.words.Document;
//import com.aspose.words.DocumentBuilder;
//import com.aspose.words.ParagraphAlignment;
//import com.aspose.words.ParagraphFormat;
//import com.aspose.words.Table;
import com.example.demo.config.MailConfig;
import com.example.demo.dto.AccountCompanyDto;
import com.example.demo.dto.AuthUserDto;
import com.example.demo.dto.ExportingCargoDto;
import com.example.demo.dto.ExportingExportDto;
import com.example.demo.dto.MailDto;
import com.example.demo.entity.AccountCompanyEntity;
import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingCargoEntity;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.entity.ExportingProductEntity;
import com.example.demo.repository.AccountCompanyRepository;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.CargoInfoRepository;
import com.example.demo.repository.ExportingProductRepository;
import com.example.demo.repository.ExportingRepository;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {
	
	// 파일이 저장되는 경로를 지정해준다
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	@Value("${user.board.pageLimit}") //파일의 페이지 수
	private int pageLimit ;
	private static final Logger log = LoggerFactory.getLogger(MainService.class);
	//----------------------------------------------------
	@Autowired
	private final  MailConfig a;
    private static final String FROM_ADDRESS = "leerexman01@naver.com";
	final ExportingRepository exportRep ;
	private  final AuthUserRepository userRep;
	private final CargoInfoRepository cargoRep;
	private final AccountCompanyRepository companyRep;
	private final ExportingProductRepository productRep;
	

	
	
	/**
	 * 여기에 exporting 
	 * @param exportId
	 * @param product
	 */
	public void saveProduct(Long exportId,ExportingProductEntity product) {
		Optional<ExportingExportEntity> export = exportRep.findById(exportId);
		ExportingExportEntity exportEntity = export.get();
		product.setExportId(exportEntity);
		productRep.save(product);
	}
	
	
	
	public AccountCompanyDto findCompany(String userId) {
		Optional<AuthUserEntity> user = userRep.findById(userId);
		AuthUserEntity userEntity = user.get();
		AccountCompanyEntity company = companyRep.findByuserId(userEntity);
		return AccountCompanyDto.toDTO(company);
	}
	
	
	
	public Page<ExportingExportDto> selectAll(String  userId,Pageable pageable,String searchItem,String searchWord) {
		Optional<AuthUserEntity> user = userRep.findById(userId);
		AuthUserEntity userEntity = user.get();
		int page = pageable.getPageNumber()-1;
//		Optional<AuthUserEntity> user = userRep.findById(userId);
//		AuthUserEntity userEntity = user.get();
//		// 모든 수출정보 뽑기
//		List<ExportingExportEntity> exportEntities = exportRep.findByuserId(userEntity);
//		List<ExportingExportDto> dto =new ArrayList<>();
//		exportEntities.forEach(ex-> dto.add(ExportingExportDto.ToDto(ex, userId)));
		
		Page<ExportingExportEntity> exportList= null;
		
		if (searchWord == null || searchWord.isEmpty()) {
		    exportList = exportRep.findAllByUserId(userEntity,PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
		} else {
		    switch (searchItem) {
		        case "buyerCompanyName":
		            exportList = exportRep.findByBuyerCompanyNameContainsAndUserId(searchWord,userEntity, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
		            break;

		        case "buyerEmail":
		            exportList = exportRep.findByBuyerEmailContainsAndUserId(searchWord,userEntity, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
		            break;
		    }
		}

		log.info("페이징정보_{}",exportList.getSize());
		Page<ExportingExportDto > list=null;
		list = exportList.map(export->new ExportingExportDto(
				export.getId(),
				export.getBuyerCompanyName(),
				export.getBuyerCompanyAddress(),
				export.getBuyerCompanyTel(),
				export.getBuyerEmail(),
				export.getIncoterm(),
				export.getPaymentMethod(),
				export.getPlaceOfLoading(),
				export.getPlaceOfUnloading(),
				export.getContractDate(),
				export.getDeadlineDate(),
				export.getRegisteredDatetime(),
				export.getProcess(),
				export.getUserId().getUsername()));
			
//	 exportDtos = exportEntities.map(export->
//	 new ExportingExportDto(export.getId(),
//			 ));
		return  list;
				
	}
	
	public void deleteCargoEntity(Long exportId) {
		Optional<ExportingExportEntity> export = exportRep.findById(exportId);
		ExportingExportEntity exportEntity= export.get();
		ExportingCargoEntity cargoEntity = cargoRep.findByExportId(exportEntity);
		cargoRep.delete(cargoEntity);
	}
	
	
	
	public void deleteExportingEntity(Long exportId) {
		Optional<ExportingExportEntity> export = exportRep.findById(exportId);
		ExportingExportEntity exportEntity= export.get();
		exportRep.delete(exportEntity);
	}
	
	
	/**
	 * 사용자를 저장하는 회원가입기능
	 * @param dto
	 * @return 
	 */
	public String saveUser(AuthUserDto dto) {
		AuthUserEntity userEntity = AuthUserEntity.ToEntity(dto);
		userRep.save(userEntity);
		log.info("정보==>{}",userEntity.getUsername());
		return userEntity.getUsername();
	}
	/**
	 * 파일의 수정을 위해 게약내용을 찾는  find 서비스__ 파일 update// 각 클래스마다 클릭하면 값을 알아야 하는 것이므로 전달 받은 
	 * @return 
	 */
	public ExportingExportDto findExportingEntity(String userId,Long exportId) {
		Optional<AuthUserEntity> user = userRep.findById(userId);
		AuthUserEntity userEntity = user.get();
		
		// 회원당 가지고있는 입력한 수출 폼
		// 여기 수정해야합니다 문제잇습니다 !!!!!!!!!!!!!!!!!!
		Optional<ExportingExportEntity> export=exportRep.findById(exportId);
		ExportingExportEntity exportEntity = export.get();
	
		
		return ExportingExportDto.ToDto(exportEntity, userId);
		
		//-------------------------------------------------------------------------문제밠생코드
	}
	/**
	 * 이것도 수정과 과현된 서비스이다
	 * @param exportId
	 * @return
	 */
	public ExportingCargoDto findExportingCargo(Long exportId) {
		log.info("exportID_{}",exportId);
		Optional<ExportingExportEntity> export = exportRep.findById(exportId);
		ExportingExportEntity exportEntity =export.get();
		log.info("수출의 정보",exportEntity.getBuyerEmail());
		ExportingCargoEntity exportCargo = cargoRep.findByExportId(exportEntity);
		log.info("화물의 정보 가로==>{}",exportCargo.getLength());
		return ExportingCargoDto.ToDto(exportCargo, exportId);
	}
	
	
	/**
	 * 사용자가 계약내용을 입력하면 그 정보를 저장하는 기능
	 * @param dto
	 * @param userId 
	 * @return 
	 */
	public Long saveExporting(ExportingExportDto dto, String userId) {
// 사용자를 외래키로 연관이된걸로
		// 사용자를 파악
		Optional<AuthUserEntity> userOptional = userRep.findById(userId);
		if (userOptional.isPresent()) {
		    AuthUserEntity user = userOptional.get();
		    // 이곳에 user를 사용한 저장 로직을 추가하세요
		    ExportingExportEntity entity = ExportingExportEntity.ToEntity(dto,user);
			// 정보저장완료
			exportRep.save(entity);
			return entity.getId();
		} else {
		    // user가 존재하지 않을 경우 적절한 예외 처리
		    throw new RuntimeException("User not found with id: " +dto.getUserId());
		}

		
	}
	/**
	 * 사용자가 화물의 정보를 입력하면 화물정보저장
	 * @param dto
	 * @param exportId 
	 */
	public void saveCargoInfo(ExportingCargoDto dto, Long exportId) {
		// dto에서 수출의 아이디를 추출한다
	
		Optional<ExportingExportEntity> exportEntity = exportRep.findById(exportId) ;
		ExportingExportEntity export = exportEntity.get();
		ExportingCargoEntity cargo=ExportingCargoEntity.ToEntity(dto, export);
		cargoRep.save(cargo);
		log.info("저장된 화물의 정보_{}",cargo.getExportId());
		
	
	}
	
	public void modifyExportingSave(ExportingExportDto exportDto,Long exportId) {
	
		Long id = exportDto.getId();
		log.info("modifyExporting_{}",exportId);
		Optional<ExportingExportEntity> export = exportRep.findById(exportId);
		ExportingExportEntity exportEntity = export.get();
		
		//---------------------------전달받은 값들을 근거로 다시 바꾼다
		String a= exportDto.getBuyerCompanyAddress();
		exportEntity.setBuyerCompanyAddress(a);
		log.info("바뀐 기업의 주소는 다음과 같다==>{}",a);
		String b= exportDto.getBuyerCompanyName();
		exportEntity.setBuyerCompanyName(b);
		log.info("바뀐 기업의 이름은 다음과 같다==>{}",b);
		String c= exportDto.getBuyerCompanyTel();
		exportEntity.setBuyerCompanyTel(c);
		String d= exportDto.getBuyerEmail();
		exportEntity.setBuyerCountry(d);
		String e =exportDto.getIncoterm();
		exportEntity.setIncoterm(e);
		String aa=exportDto.getPaymentMethod();
		exportEntity.setPaymentMethod(aa);
		String ab= exportDto.getPlaceOfLoading();
		exportEntity.setPlaceOfLoading(ab);
		String ac = exportDto.getPlaceOfUnloading();
		exportEntity.setPlaceOfUnloading(ac);
		LocalDate ad = exportDto.getContractDate();
		exportEntity.setContractDate(ad);
		LocalDate ae = exportDto.getDeadlineDate();
		exportEntity.setContractDate(ae);
		
		log.info("업데이트 수정 날짜_{}",ad);
		// 값들을 저장하겟다
		exportRep.save(exportEntity);
		
		//-------------------------------------- 이걸로 견적서 내용 수정은 완료된다
	}
	/**
	 * 변경되 화물정보 업데이트하는 함수이다
	 * @param cargoDto
	 * @param exportId
	 */
	public void modifyCargoSave(ExportingCargoDto cargoDto, Long exportId) {
		// TODO Auto-generated method stub
		// 제일먼저 최초로 저장된 화물의 정보를 찾아야한다
		Optional<ExportingExportEntity> export= exportRep.findById(exportId);
		ExportingExportEntity exportEntity = export.get();
		//화물의 정보를 찾았어요!!!!!!!!!!!!!!!!!! ㅅㅂ!!!!!!!!!!!!!!!!!!
		ExportingCargoEntity cargoEntity= cargoRep.findByExportId(exportEntity);
		// 전달받은 것들로 다시 update하자 
		String a = cargoDto.getName();
		cargoEntity.setName(a);
		log.info("화물정보 수정 서비스 ==> {}",a);
		double b = cargoDto.getWidth();
		cargoEntity.setWidth(b);
		double c= cargoDto.getHeight();
		cargoEntity.setHeight(c);
		double d = cargoDto.getLength();
		cargoEntity.setLength(d);
		String e = cargoDto.getContainerType();
		cargoEntity.setContainerType(e);
		double weight = cargoDto.getWeight();
		cargoEntity.setWeight(weight);
		int quantity = cargoDto.getQuantity();
		cargoEntity.setQuantity(quantity);
		String isDangerous = cargoDto.getIsDangerous();
		cargoEntity.setIsDangerous(isDangerous);
		
		cargoRep.save(cargoEntity);
	}
	
	
	/**
	 * 메일을 보내는 작업
	 * @param mailDto
	 * @param filePath
	 */
	public void mailSend(MailDto mailDto,String filePath) {
		 // 여기는 저장된 파일까지 다시 보내는 코드 시작입니다
	 	SimpleMailMessage message = new SimpleMailMessage();
    	JavaMailSender mailSender = a.javaMailService();
        MimeMessage message1 = mailSender.createMimeMessage();
        

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message1, true); // true for multipart
            helper.setTo(mailDto.getAddress());
            helper.setFrom(MainService.FROM_ADDRESS);
            log.info("메일의 제목_{}",mailDto.getTitle());
            helper.setSubject(mailDto.getTitle());
            helper.setText(mailDto.getMessage() + "이 날까지 답장을 요청드립니다: " + mailDto.getToreply());
            if(!mailDto.getAttachment1().isEmpty()) {
            	log.info("해당파일은 조재합니다_{}",mailDto.getAttachment1().getName());
            	helper.addAttachment(mailDto.getAttachment1().getOriginalFilename(), mailDto.getAttachment1());
            }else {
            	log.info("해당 파일은 존재하지 않습니다");
            }
            if(!mailDto.getAttachment2().isEmpty()) {
            	log.info("해당파일은 조재합니다_{}",mailDto.getAttachment2().getName());
            	helper.addAttachment(mailDto.getAttachment2().getOriginalFilename(), mailDto.getAttachment2());
            }else {
            	log.info("해당 파일2은 존재하지 않습니다");
            }
          
           
            // 파일 첨부
            File file = new File(filePath);
            if (file.exists()) {
                helper.addAttachment(file.getName(), file);
                log.info("정보는 다음과 같다 ==> {}", message);
                log.info("정보는 다음과 같다 ==> {}", message1);
                mailSender.send(message1);
            } 

           
          
        } catch (Exception e) {
            log.error("메일 전송 중 오류 발생: {}", e.getMessage());
        }
	}



	public AuthUserDto findUser(String usertId) {
		// TODO Auto-generated method stub
		Optional<AuthUserEntity> user = userRep.findById(usertId);
		AuthUserEntity userEntity = user.get();
		return AuthUserDto.toDto(userEntity);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
////
	public String generateInvoice(Map<String, String> invoiceData) throws Exception {
	    
	   

	    // 템플릿 파일 읽기
	    InputStream templateStream = getClass().getResourceAsStream("/template/invoice_template1.docx");
	    if (templateStream == null) {
	        throw new FileNotFoundException("Template file not found. Please ensure the file is located in src/main/resources/template1/");
	    }

	  
	 

	    try (XWPFDocument document = new XWPFDocument(templateStream)) {
	        // 문서의 모든 단락을 순회하며 플레이스홀더를 교체
	        document.getParagraphs().forEach(paragraph -> replaceTextInParagraph(paragraph, invoiceData));

	        // 모든 테이블을 순회하며 셀 내의 단락도 교체
	        document.getTables().forEach(table ->
	            table.getRows().forEach(row ->
	                row.getTableCells().forEach(cell ->
	                    cell.getParagraphs().forEach(paragraph -> replaceTextInParagraph(paragraph, invoiceData))
	                )
	            )
	        );
	        
	        // 업데이트된 문서 저장
	        String result = null;
		  	try {
		  		result = FileService.saveFile(document,uploadPath);
		  		 log.info("파일의정보는 다음과 같습니다: {}",result);
		  		return result;
		  	} catch (Exception e) {
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  	}
	    }
		return null;
		
	}




	private void replaceTextInParagraph(XWPFParagraph paragraph, Map<String, String> invoiceData) {
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs != null) {
            // 전체 문장의 텍스트를 가져옴
            StringBuilder paragraphText = new StringBuilder();
            for (XWPFRun run : runs) {
                String runText = run.getText(0);
                if (runText != null) {
                    paragraphText.append(runText);
                }
            }

            // 플레이스홀더 교체
            String updatedText = paragraphText.toString();
            for (Map.Entry<String, String> entry : invoiceData.entrySet()) {
                if (updatedText.contains(entry.getKey())) {
                    log.info("Replacing placeholder: {} with value: {}", entry.getKey(), entry.getValue());
                    updatedText = updatedText.replace(entry.getKey(), entry.getValue());
                }
            }

            // 교체된 텍스트를 새로 설정
            if (!updatedText.equals(paragraphText.toString())) {
                // 기존 모든 run 삭제
                int numberOfRuns = runs.size();
                for (int i = numberOfRuns - 1; i >= 0; i--) {
                    paragraph.removeRun(i);
                }
                // 새로운 텍스트로 run 생성
                XWPFRun newRun = paragraph.createRun();
                newRun.setText(updatedText);
                log.info("Updated paragraph text: {}", updatedText);
            }
        }
    }


 

}
	
		
		
