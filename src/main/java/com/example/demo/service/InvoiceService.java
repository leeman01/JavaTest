package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

        public void generateInvoice(Map<String, String> invoiceData, String filePath, byte[] signatureImageBytes) throws IOException, InvalidFormatException {
        	
            logger.info("generateInvoice() called with filePath: {}", filePath);
        
        // 템플릿 파일 읽기
        InputStream templateStream = getClass().getResourceAsStream("/template/invoice_template.docx");
        if (templateStream == null) {
            throw new FileNotFoundException("Template file not found. Please ensure the file is located in src/main/resources/template/");
        }

        // 임시 디렉토리에 파일 저장 경로 설정
        String tempDir = System.getProperty("java.io.tmpdir");
        String tempFilePath = tempDir + "output_invoice.docx";
        logger.info("Temporary file path: {}", tempFilePath);  // 로그 추가

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
            
         // 이미지 추가 작업 (한 번만 수행)
            if (signatureImageBytes != null) {
                boolean imageAdded = false;
                for (XWPFParagraph paragraph : document.getParagraphs()) {
                    if (addImageToParagraph(paragraph, signatureImageBytes)) {
                        imageAdded = true;
                        break;  // 이미지를 추가한 후 더 이상 순회할 필요 없음
                    }
                }

                if (!imageAdded) {
                    // 테이블 안의 단락에서도 이미지 플레이스홀더를 교체
                    for (XWPFTable table : document.getTables()) {
                        for (XWPFTableRow row : table.getRows()) {
                            for (XWPFTableCell cell : row.getTableCells()) {
                                for (XWPFParagraph paragraph : cell.getParagraphs()) {
                                    if (addImageToParagraph(paragraph, signatureImageBytes)) {
                                        imageAdded = true;
                                        break;  // 이미지를 추가한 후 더 이상 순회할 필요 없음
                                    }
                                }
                                if (imageAdded) break;
                            }
                            if (imageAdded) break;
                        }
                        if (imageAdded) break;
                    }
                }
            }
            // 업데이트된 문서 저장
            logger.info("Saving updated document to {}", tempFilePath);
            try (FileOutputStream fos = new FileOutputStream(tempFilePath)) {
                document.write(fos);
            }
        } catch (IOException e) {
            logger.error("Error while generating invoice: ", e);
            throw e;
        }
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
                    logger.info("Replacing placeholder: {} with value: {}", entry.getKey(), entry.getValue());
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
                logger.info("Updated paragraph text: {}", updatedText);
            }
        }
    }

    private boolean addImageToParagraph(XWPFParagraph paragraph, byte[] imageBytes) {
        String paragraphText = paragraph.getText();  // 현재 단락의 텍스트를 가져옴
        if (paragraphText.contains("{shipperSignature}")) {
            try (InputStream inputStream = new ByteArrayInputStream(imageBytes)) {
                XWPFRun run = paragraph.createRun();
                // 기존 텍스트에서 '{shipperSignature}' 부분을 제거
                paragraphText = paragraphText.replace("{shipperSignature}", "");
                
                // 수정된 텍스트를 설정하고 이미지 삽입
                int numberOfRuns = paragraph.getRuns().size();
                for (int i = numberOfRuns - 1; i >= 0; i--) {
                    paragraph.removeRun(i);
                }
                run = paragraph.createRun();
                run.setText(paragraphText);
                
                // 이미지 삽입
                run.addPicture(inputStream, XWPFDocument.PICTURE_TYPE_PNG, "signature_image.png", 1800000, 810000);
                logger.info("Image successfully added in place of {shipperSignature}");
                return true;
            } catch (InvalidFormatException | IOException e) {
                logger.error("Error while adding image to paragraph: ", e);
            }
        }
        return false;  // 이미지 추가 실패
    }

}

