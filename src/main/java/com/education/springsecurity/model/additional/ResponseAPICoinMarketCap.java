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
public class ResponseAPICoinMarketCap {

    private StatusApiCMC status;
    private DataCMC data;
}
