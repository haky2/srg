package com.srg.repository;

import com.querydsl.jpa.JPQLQuery;
import com.srg.entity.Sample;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.srg.entity.QSample.sample;

import java.util.List;

public class SampleRepositoryImpl extends QuerydslRepositorySupport {

    public SampleRepositoryImpl() {
        super(Sample.class);
    }

    public List<Sample> findByName(String name) {
        JPQLQuery<Sample> query = from(sample).where(sample.name.eq(name));

        return query.fetch();
    }
}
