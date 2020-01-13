package com.srg.service;

import com.srg.entity.Sample;
import com.srg.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @Transactional(readOnly = true)
    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sample getSample(Long sampleId) {
        return sampleRepository.findById(sampleId).get();
    }

    @Transactional
    public Sample setSample(Sample command) {
        return sampleRepository.save(command);
    }

    @Transactional
    public Sample putSample(Long sampleId, Sample sample) {
        sample = sampleRepository.findById(sampleId).get();
        return sampleRepository.saveAndFlush(sample);
    }

    @Transactional
    public void delSample(Long sampleId) {
        sampleRepository.deleteById(sampleId);
    }

}
