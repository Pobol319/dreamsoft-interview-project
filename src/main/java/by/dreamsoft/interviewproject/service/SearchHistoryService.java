package by.dreamsoft.interviewproject.service;

import by.dreamsoft.interviewproject.model.SearchHistory;

import java.io.IOException;
import java.util.List;

public interface SearchHistoryService {

    List<SearchHistory> getAllOrderedByDate();

    void save(SearchHistory searchHistory);

    List<String> getAllRowsWithWord(SearchHistory searchHistory) throws IOException;
}
