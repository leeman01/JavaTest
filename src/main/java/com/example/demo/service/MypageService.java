package com.example.demo.service;

import java.time.format.DateTimeFormatter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuthUserEntity;
import com.example.demo.entity.ExportingExportEntity;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.repository.ExportingExportRepository;
import com.example.demo.repository.ExportingProductRepository;
import com.example.demo.vo.MyexportDetailVO;
import com.example.demo.vo.MyexportVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MypageService {
    
    private final AuthUserRepository authUserRepository;
    private final ExportingExportRepository exportingExportRepository;
    private final ExportingProductRepository exportingProdcutRepository;


    enum ProgressStatus {
        선적전(0), 선적시(1), 운송중(2), 도착시(3), 도착후(4), 수출완료(99);

        private final int value;

        ProgressStatus(int value) {
            this.value = value;
        }

        private static final Map<Integer, ProgressStatus> map = Map.of(
                0, 선적전,
                1, 선적시,
                2, 운송중,
                3, 도착시,
                4, 도착후,
                99, 수출완료
        );

        public static ProgressStatus of(int value) {
            return map.getOrDefault(value, null);
        }
    }

    public List<MyexportVO> getMyexportList(String userId) {
        Optional<AuthUserEntity> user = authUserRepository.findById(userId);
        List<ExportingExportEntity> exportingExportEntities = exportingExportRepository.findByuserId(user);
        List<ExportingExportEntity> sortedEntities = exportingExportEntities.stream()
                .sorted(Comparator.comparing(ExportingExportEntity::getProcess))
                .collect(Collectors.toList());

        return sortedEntities.stream()
                .map(entity -> {
                    ProgressStatus status = ProgressStatus.of(entity.getProcess());
                    String progressName = (status != null) ? status.name() : "알 수 없음"; // 디폴트 상태 처리

                    return new MyexportVO(
                            entity.getId(), // Handle potential Long to int conversion issue
                            entity.getBuyerCompanyName(),
                            progressName,
                            entity.getIncoterm(),
                            // Format deadline to a String if necessary (adjust based on your needs)
                            entity.getDeadlineDate().format(DateTimeFormatter.ofPattern("yyyy. MM. dd")),
                            exportingProdcutRepository.findByexportId(entity)
                    );
                })
                .collect(Collectors.toList());
    }

    public MyexportDetailVO getMyexportDetail(Long exportId){
        Optional<ExportingExportEntity> exportingExportEntity = exportingExportRepository.findById(exportId);
        ExportingExportEntity entity = exportingExportEntity.get();
        MyexportDetailVO myexportDetailVO = new MyexportDetailVO(entity,ProgressStatus.of(entity.getProcess()).name());
        return myexportDetailVO;
    }
}