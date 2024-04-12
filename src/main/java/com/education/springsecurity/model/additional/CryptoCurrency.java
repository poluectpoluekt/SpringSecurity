package com.education.springsecurity.model.additional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrency {

    private int id;
    private String name;
    private String symbol;
    private String slug;
    private int num_market_pairs;
    private String date_added;
    private List<String> tags;
    private int max_supply;
    private int circulating_supply;
    private int total_supply;
    private boolean infinite_supply;
    private Object platform;
    private int cmc_rank;
    private Object self_reported_circulating_supply;
    private Object self_reported_market_cap;
    private Object tvl_ratio;
    private String last_updated;
    private Quote quote;
}
