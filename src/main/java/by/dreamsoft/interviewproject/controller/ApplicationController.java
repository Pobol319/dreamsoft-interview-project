package by.dreamsoft.interviewproject.controller;

import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.model.SearchHistoryDto;
import by.dreamsoft.interviewproject.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private SearchHistoryService service;

    @GetMapping("/showHistory")
    public List<SearchHistory> getAll() {
        return service.getAllOrderedByDate();
    }

    @PostMapping("/searchWord")
    public List<String> getAllRowsWithWord(@RequestBody @Valid SearchHistoryDto searchHistoryDto) throws IOException {
        return service.getAllRowsWithWord(searchHistoryDto);
    }
}
