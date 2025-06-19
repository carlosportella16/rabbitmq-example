package com.tech.pfms.listener.dto;

import java.math.BigDecimal;

public record PixReq(String channel,
                     String from,
                     String to,
                     BigDecimal value) {
}
