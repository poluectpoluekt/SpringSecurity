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
public class DataCMC {

    private List<CryptoCurrency> cryptoCurrencies;
}
