package com.education.springsecurity.service;

import com.education.springsecurity.exception.ErrorCryptocurrencyDataDownload;
import com.education.springsecurity.model.additional.CryptoCurrency;
import com.education.springsecurity.model.additional.DataCMC;
import com.education.springsecurity.model.additional.ResponseAPICoinMarketCap;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @InjectMocks
    EventServiceImpl eventService;

    @Mock
    RestTemplate restTemplate;

    @Mock
    DataCMC dataCMC;



    @Test
    @DisplayName("searchPopularCryptocurrency возвращает List, содержащий не более 10 элементов")
    void searchPopularCryptocurrency_restTemplateSuccess_ReturnList10Elements() throws ErrorCryptocurrencyDataDownload {

        ResponseAPICoinMarketCap responseAPI = new ResponseAPICoinMarketCap();

        DataCMC list = new DataCMC(List.of(  //List из 12 элементов
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class),
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class),
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class),
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class),
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class),
                Mockito.mock(CryptoCurrency.class), Mockito.mock(CryptoCurrency.class)));
        responseAPI.setData(list);

        ResponseEntity<ResponseAPICoinMarketCap> responseEntity = new ResponseEntity<>(responseAPI, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(Class.class))).thenReturn(responseEntity);


        List<CryptoCurrency> result = eventService.searchPopularCryptocurrency();

        assertTrue(result instanceof List<CryptoCurrency>);
        assertEquals(10,result.size());
    }


    @Test
    @DisplayName("searchPopularCryptocurrency возвращает исключение, об неудачном запросе на сервис CoinMarketCap")
    void searchPopularCryptocurrency_restTemplateFail_ReturnException() {

        ResponseAPICoinMarketCap responseAPI = new ResponseAPICoinMarketCap();

        responseAPI.setData(null);

        ResponseEntity<ResponseAPICoinMarketCap> responseEntity = new ResponseEntity<>(responseAPI, HttpStatus.BAD_REQUEST);

        Mockito.when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(), any(Class.class))).thenReturn(responseEntity);

        assertThrows(ErrorCryptocurrencyDataDownload.class, () -> eventService.searchPopularCryptocurrency());
    }

}