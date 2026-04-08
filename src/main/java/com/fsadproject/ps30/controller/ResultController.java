package com.fsadproject.ps30.controller;

import com.fsadproject.ps30.entity.Result;
import com.fsadproject.ps30.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    // ✅ EXISTING METHOD (keep it)
    @PostMapping
    public Result calculate(@RequestBody Result request) {
        return service.calculateResult(
                request.getTotalScore(),
                request.getUser(),
                request.getAssessment()
        );
    }

    // 🔥 NEW METHOD (simple submit for demo)
    @PostMapping("/submit")
    public Result submitSimple(@RequestBody Result request) {
        return service.saveSimpleResult(request);
    }

    // ✅ GET ALL RESULTS
    @GetMapping
    public List<Result> getAllResults() {
        return service.getAllResults();
    }
}