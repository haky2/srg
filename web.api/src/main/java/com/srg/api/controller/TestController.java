package com.srg.api.controller;

import com.srg.api.service.ApiSampleService;
import com.srg.entity.Sample;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ApiSampleService apiSampleService;

    @GetMapping
    public List<Sample> getSamples() {
        return apiSampleService.getSamples();
    }

    @ApiOperation(value = "테스트용", notes = "그냥 한번 테스트로 해 봤음. just for test")
    @GetMapping("haky")
    public Sample getHaky() {
        return new Sample("haky");
    }

    @GetMapping("{sampleId}")
    public Sample getSample(@PathVariable Long sampleId) {
        return apiSampleService.getSample(sampleId);
    }

    @PostMapping
    public Sample setSample(@RequestBody Sample command) {
        return apiSampleService.setSample(command);
    }

    @PutMapping("{sampleId}")
    public Sample putSample(@PathVariable Long sampleId, @RequestBody Sample command) {
        return apiSampleService.putSample(sampleId, command);
    }

    @DeleteMapping("{sampleId}")
    public void delSample(@PathVariable Long sampleId) {
        apiSampleService.delSample(sampleId);
    }

}
