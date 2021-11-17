package com.vp.starter.service;

import com.vp.starter.entities.JDate;
import com.vp.starter.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired
    DateRepository dateRepository;

    public String getTZ() {
        return dateRepository.getTZ();
    }

    public List<JDate> getJdate() {
        return dateRepository.getDate();
    }
}
