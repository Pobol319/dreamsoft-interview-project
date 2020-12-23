package by.dreamsoft.interviewproject.controller;

import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private SearchHistoryService service;

    @GetMapping("/showHistory")
    public List<SearchHistory> getAll() {
        return service.getAllOrderedByDate();
    }

    @PostMapping("/searchWord")
    public List<String> getAllRowsWithWord(@RequestBody SearchHistory searchHistory) throws IOException {
        if (searchHistory.getFilePath() == null || searchHistory.getSearchWord() == null) {
            return new ArrayList<>();
        }

        service.save(searchHistory);
        return service.getAllRowsWithWord(searchHistory);
    }
}
