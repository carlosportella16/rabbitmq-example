package com.tech.pixms.controller.dto;

import java.math.BigDecimal;

public record PixReq(String channel,
                     String from,
                     String to,
                     BigDecimal value) {
}
