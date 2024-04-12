package com.education.springsecurity.model.additional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class USD {

    private BigDecimal price;

    private BigDecimal volume24h;

    private BigDecimal volumeChange24h;

    private BigDecimal percentChange1h;

    private BigDecimal percentChange24h;

    private BigDecimal percentChange7d;

    private BigDecimal percentChange30d;

    private BigDecimal percentChange60d;

    private BigDecimal percentChange90d;

    private BigDecimal marketCap;

    private BigDecimal marketCapDominance;

    private BigDecimal fullyDilutedMarketCap;

    private BigDecimal tvl;

    private LocalDateTime lastUpdated;
}
