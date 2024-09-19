package com.app.app.period.domain.service;

import com.app.app.period.persistence.Period;

import java.util.List;

public interface IPeriod {
    List<Period> findAll();
    Period findById(Long id);
    Period save(Period period);
    Period update(Long id, Period period);
    void delete(Long id);
}
