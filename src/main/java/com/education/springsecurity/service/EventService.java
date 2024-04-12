package com.education.springsecurity.service;

import com.education.springsecurity.exception.ErrorCryptocurrencyDataDownload;
import com.education.springsecurity.model.Event;
import com.education.springsecurity.model.additional.CryptoCurrency;

import java.util.List;

public interface EventService {

    public void create();

    public Event read();

    public void update();

    public void delete();

    public List<CryptoCurrency> searchPopularCryptocurrency() throws ErrorCryptocurrencyDataDownload;


}
