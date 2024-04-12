package com.education.springsecurity.service;


import com.education.springsecurity.exception.ErrorCryptocurrencyDataDownload;
import com.education.springsecurity.mapper.EventMapper;
import com.education.springsecurity.model.Event;
import com.education.springsecurity.model.additional.CryptoCurrency;
import com.education.springsecurity.model.additional.DataCMC;
import com.education.springsecurity.model.additional.ResponseAPICoinMarketCap;
import com.education.springsecurity.repository.EventRepository;
import com.education.springsecurity.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;
    private final RestTemplate restTemplate;

    @Value("${spring.KEY_CMC}")
    private final String KEY_CMC;


    @Override
    public void create() {

    }

    @Override
    public Event read() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<CryptoCurrency> searchPopularCryptocurrency() throws ErrorCryptocurrencyDataDownload {
        ResponseEntity<ResponseAPICoinMarketCap> cryptoListTotal = restTemplate.exchange(
                "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=" + KEY_CMC,
                HttpMethod.GET, null, ResponseAPICoinMarketCap.class);
        if(cryptoListTotal.getBody().getData() == null){
            throw new ErrorCryptocurrencyDataDownload("Failed to download a list of cryptocurrencies from the CoinMarketCap service.");


        } else {

            return cryptoListTotal.getBody()
                    .getData()
                    .getCryptoCurrencies()
                    .stream().sorted(Comparator.comparingInt(CryptoCurrency::getId)).limit(10).collect(Collectors.toList());
        }
    }
}
