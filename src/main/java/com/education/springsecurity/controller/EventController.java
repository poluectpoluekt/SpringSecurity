package com.education.springsecurity.controller;

import com.education.springsecurity.exception.ErrorCryptocurrencyDataDownload;
import com.education.springsecurity.model.additional.CryptoCurrency;
import com.education.springsecurity.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("event/api")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    public List<CryptoCurrency> getPopularCryptocurrency() throws ErrorCryptocurrencyDataDownload {
        return eventService.searchPopularCryptocurrency();
    }


}
