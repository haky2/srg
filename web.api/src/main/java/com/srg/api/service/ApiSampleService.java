package com.srg.api.service;

import com.srg.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiSampleService {

    @Autowired
    private ApiSampleService apiSampleService;

    public List<Sample> getSamples() {
        return apiSampleService.getSamples();
    }

    public Sample getSample(Long sampleId) {
        return apiSampleService.getSample(sampleId);
    }

    public Sample setSample(Sample command) {
        return apiSampleService.setSample(command);
    }

    public Sample putSample(Long sampleId, Sample command) {
        Sample sample = apiSampleService.getSample(sampleId);
        sample.setName(command.getName());

        return apiSampleService.putSample(sampleId, sample);
    }

    public void delSample(Long sampleId) {
        apiSampleService.delSample(sampleId);
    }

}
