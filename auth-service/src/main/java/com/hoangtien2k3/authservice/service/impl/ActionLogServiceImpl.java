package com.hoangtien2k3.authservice.service.impl;

import com.hoangtien2k3.authmodel.dto.PaginationDTO;
import com.hoangtien2k3.authmodel.dto.request.ActionLogRequest;
import com.hoangtien2k3.authmodel.dto.response.SearchActionLogResponse;
import com.hoangtien2k3.authmodel.model.ActionLog;
import com.hoangtien2k3.authservice.constants.ActionLogType;
import com.hoangtien2k3.authservice.repotemplate.ActionLogRepositoryTemplate;
import com.hoangtien2k3.authservice.service.ActionLogService;
import com.reactify.constants.CommonErrorCode;
import com.reactify.constants.Constants;
import com.reactify.exception.BusinessException;
import com.reactify.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionLogServiceImpl implements ActionLogService {

    private final ActionLogRepositoryTemplate actionLogRepositoryTemplate;

    @Override
    public Mono<SearchActionLogResponse> search(ActionLogRequest request) {
        validate(request);
        request.setPageIndex(DataUtil.safeToInt(request.getPageIndex(), 1));
        request.setPageSize(DataUtil.safeToInt(request.getPageSize(), 10));
        return Mono.zip(
                        actionLogRepositoryTemplate.search(request).collectList(),
                        actionLogRepositoryTemplate.count(request))
                .flatMap(tuple -> {
                    PaginationDTO paginationDTO = PaginationDTO.builder()
                            .pageIndex(request.getPageIndex())
                            .pageSize(request.getPageSize())
                            .totalRecords(tuple.getT2())
                            .build();
                    SearchActionLogResponse response = SearchActionLogResponse.builder()
                            .actionLogs(tuple.getT1())
                            .pagination(paginationDTO)
                            .build();
                    return Mono.just(response);
                });
    }

    @Override
    public Mono<Resource> exportUser(ActionLogRequest request) {
        validate(request);
        request.setPageIndex(null);
        request.setPageSize(null);
        return actionLogRepositoryTemplate
                .search(request)
                .collectList()
                .flatMap(actionLogList -> Mono.fromCallable(() -> writeExcel(writeLogExcel(actionLogList))));
    }

    private void validate(ActionLogRequest request) {
        if (!DataUtil.isNullOrEmpty(request.getFromDate())
                && !DataUtil.isNullOrEmpty(request.getToDate())
                && request.getToDate().getDayOfYear() - request.getFromDate().getDayOfYear() > 31) {
            throw new BusinessException(CommonErrorCode.INVALID_PARAMS, "data.search.exceed.error");
        }
    }

    private ByteArrayResource writeExcel(Workbook workbook) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            workbook.write(os);
            return new ByteArrayResource(os.toByteArray()) {
                @Override
                public String getFilename() {
                    return "List_User_Action_Log.xlsx";
                }
            };
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new BusinessException(CommonErrorCode.INTERNAL_SERVER_ERROR, "export.error");
        }
    }

    private Workbook writeLogExcel(List<ActionLog> actionLogList) {
        try (InputStream templateInputStream =
                new ClassPathResource("template/template_action_log.xlsx").getInputStream()) {
            Workbook workbook = new XSSFWorkbook(templateInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            String currentDate = DataUtil.formatDate(LocalDateTime.now(), Constants.DateTimePattern.DMY, "");
            Cell exportDateCell = sheet.getRow(1).getCell(4);
            exportDateCell.setCellValue(exportDateCell.getStringCellValue().replace("${date}", currentDate));
            DataUtil.formatDate(LocalDateTime.now(), Constants.DateTimePattern.DMY_HMS, "");

            int rowCount = 4;
            int index = 1;
            CellStyle centerStyle = workbook.createCellStyle();
            centerStyle.setBorderBottom(BorderStyle.THIN);
            centerStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            centerStyle.setBorderRight(BorderStyle.THIN);
            centerStyle.setRightBorderColor(IndexedColors.BLUE.getIndex());
            centerStyle.setBorderTop(BorderStyle.THIN);
            centerStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            centerStyle.setBorderLeft(BorderStyle.THIN);
            centerStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            centerStyle.setAlignment(HorizontalAlignment.CENTER);

            CellStyle style = workbook.createCellStyle();
            style.setBorderBottom(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderRight(BorderStyle.THIN);
            style.setRightBorderColor(IndexedColors.BLUE.getIndex());
            style.setBorderTop(BorderStyle.THIN);
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());
            style.setBorderLeft(BorderStyle.THIN);
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setAlignment(HorizontalAlignment.LEFT);
            for (ActionLog actionLog : actionLogList) {
                Row row = sheet.createRow(rowCount++);
                writeRow(
                        row,
                        centerStyle,
                        style,
                        0,
                        Arrays.asList(
                                String.valueOf(index++),
                                actionLog.getUsername(),
                                actionLog.getIp(),
                                DataUtil.safeToString(ActionLogType.MAP.get(actionLog.getType())),
                                DataUtil.formatDate(actionLog.getCreateAt(), Constants.DateTimePattern.DMY_HMS, "")));
            }
            return workbook;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private void writeRow(Row row, CellStyle centerStyle, CellStyle cellStyle, int startIndex, List<String> rowData) {
        int cellIndex = startIndex;
        for (String data : rowData) {
            Cell cell = row.createCell(cellIndex++);
            cell.setCellValue(data);
            if (cellIndex == 1) {
                cell.setCellStyle(centerStyle);
            } else {
                cell.setCellStyle(cellStyle);
            }
        }
    }
}
