package com.example.demo.vo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.example.demo.entity.ExportingExportEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public final class MyexportDetailVO {
        private String buyerCompanyName;
        private String buyerEmail;
        private String incoterm;
        private String expDclrNo; // 수출신고번호
        private String acptDt; // 수출신고 수리일자
        private String loadDtyTmIm; // 적재의무기간
        private String ldpInscTrgtYn; // 적재지검사대상
        private String blNo = ""; // BL번호
        private String shpmCmplYn = ""; // 선적여부
        private String sanm = ""; // 선박편명
        private String tkofDt = ""; //출항일자
        private String csclWght = "";  // 통관중량
        private String csclPckUt = ""; // 통관포장단위
        private String csclPckGcnt = ""; // 통관포장개수
        private String shpmWght="";  // 선적중량
        private String shpmPckUt = ""; // 선적포장단위
        private String shpmPckGcnt =""; // 선적포장개수
        private int process; // 수출진행단계
        private String processName;
        private String itemName; // 상품명
        private String hsCode; // hs code
        private String totalQuantity; // 총수량
        private String pricePerUnit; // 단위가격
        // private final ExportingExportEntity exportingExportEntity;
        // private final ExportingProductEntity exportingProductEntity;
        // private final ExportingCargoEntity exportingCargoEntity;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd");
        

        public MyexportDetailVO(ExportingExportEntity exportingExportEntity, String processName){
                this.buyerCompanyName = exportingExportEntity.getBuyerCompanyName();
                this.buyerEmail = exportingExportEntity.getBuyerEmail();
                this.incoterm = exportingExportEntity.getIncoterm();
                this.expDclrNo = generateRandomExpDclrNo();
                LocalDate stDate = addRandomDays(exportingExportEntity.getContractDate());
                this.acptDt = stDate.format(formatter);
                this.loadDtyTmIm = getLoadDtyTmIm(stDate).format(formatter);
                this.ldpInscTrgtYn = "비대상";
                this.itemName="네모 고구마";
                this.hsCode="0714200000";
                this.totalQuantity = "20,000";
                this.pricePerUnit = "40";
                
                double weight = generateRandomWeight(10,1000);
                int count = generateRandomPackageCount(1,99);
                // 선적이 된 경우
                if (exportingExportEntity.getProcess()>=1){ 
                        this.blNo = generateBillOfLadingNumber();
                        this.csclWght = String.valueOf(weight);
                        this.csclPckGcnt = String.valueOf(count);
                        this.csclPckUt = "KG";
                        this.shpmCmplYn = "선적완료";
                        this.sanm = generateShipName();
                        this.tkofDt = subtractRandomDays(exportingExportEntity.getDeadlineDate()).format(formatter);
                        this.shpmWght = String.valueOf(weight);
                        this.shpmPckGcnt = String.valueOf(count);
                        this.shpmPckUt = "KG";
                }
                this.process = exportingExportEntity.getProcess();
                this.processName = processName;
        }

        private static String generateRandomExpDclrNo() {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
        
                sb.append(random.nextInt(9000) + 1000);
                sb.append("-");
        
                sb.append(String.format("%02d", random.nextInt(12) + 1));
                sb.append("-");
        
                sb.append(String.format("%07d", random.nextInt(10000000)));
        
                return sb.toString();
        }

        public static LocalDate addRandomDays(LocalDate startDate) {
                Random random = new Random();
                int randomDays = random.nextInt(12) + 3; // 3 ~ 14 사이의 랜덤한 일수 생성
                Period period = Period.ofDays(randomDays);
                return startDate.plus(period);
        }

        public static LocalDate subtractRandomDays(LocalDate startDate){
                Random random = new Random();
                int randomDays = random.nextInt(15) + 7; 
                Period period = Period.ofDays(randomDays);
                return startDate.minus(period);
        }

        public static LocalDate getLoadDtyTmIm(LocalDate acptDt){
                Period period = Period.ofDays(30);
                return acptDt.plus(period);
        }
        
        public static String generateBillOfLadingNumber() {
                String[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
                Random random = new Random();
        
                // 3자리 영문자 + 8자리 숫자 형식으로 생성
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                        sb.append(alphabets[random.nextInt(26)]);
                }
                for (int i = 0; i < 8; i++) {
                        sb.append(random.nextInt(10));
                }
                return sb.toString();
        }

        public static String generateShipName() {
                String[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
                Random random = new Random();
        
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                        sb.append(alphabets[random.nextInt(26)]);
                }
                for (int i = 0; i < 4; i++) {
                        sb.append(random.nextInt(10));
                }
                return sb.toString();
        }

        public static double generateRandomWeight(double minWeight, double maxWeight) {
                Random random = new Random();
                double randomValue = minWeight + (maxWeight - minWeight) * random.nextDouble();
                // 소수점 첫째 자리에서 반올림
                double roundedValue = Math.round(randomValue * 10) / 10.0;
                return roundedValue;
        }

        public static int generateRandomPackageCount(int minCount, int maxCount) {
                Random random = new Random();
                return random.nextInt(maxCount - minCount + 1) + minCount;
        }
}