package com.hoangtien2k3.notimodel.dto.response;

import java.util.List;

public record CountNoticeResponseDTO(Integer total, List<CountNoticeDTO> detail) {}