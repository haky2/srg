package com.srg.repository;

import com.srg.entity.Sample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SampleRepositoryTest {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleRepositoryImpl sampleRepositoryImpl;

    @Test
    public void add () {
        sampleRepository.save(new Sample( "haky"));
        Optional<Sample> saved = sampleRepository.findById(1L);

        assertThat(saved.get().getName(), is("haky"));
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "haky2";
        sampleRepository.save(new Sample(name));

        //when
        List<Sample> result = sampleRepositoryImpl.findByName("haky2");

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is(name));
    }
}