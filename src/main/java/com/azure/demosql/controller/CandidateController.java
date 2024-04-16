package com.azure.demosql.controller;

import com.azure.demosql.model.Candidate;
import com.azure.demosql.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/interview")
public class CandidateController {

    @Autowired
    CandidateRepo candidateRepo;

    @GetMapping("/candidate")
    public Iterable<Candidate> getCandidates() {
        return candidateRepo.findAll();
    }

    @PostMapping("/addCandidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        candidateRepo.save(candidate);
        return ResponseEntity.ok(candidate);
    }
}
