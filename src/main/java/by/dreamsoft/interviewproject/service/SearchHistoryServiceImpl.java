package by.dreamsoft.interviewproject.service;

import by.dreamsoft.interviewproject.comparator.SearchHistoryComparator;
import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    private SearchHistoryRepository repository;

    @Override
    public List<SearchHistory> getAllOrderedByDate() {
        List<SearchHistory> searchHistoryList = repository.findAll();
        searchHistoryList.sort(new SearchHistoryComparator());
        return searchHistoryList;
    }

    @Override
    public void save(SearchHistory searchHistory) {
        searchHistory.setDate(new Date());
        repository.save(searchHistory);
    }

    @Override
    public List<String> getAllRowsWithWord(SearchHistory searchHistory) throws IOException {
        String file = searchHistory.getFilePath();
        String word = searchHistory.getSearchWord();

        return Files.lines(Paths.get(file))
                .map(String::trim)
                .filter(p -> p.contains(word))
                .collect(Collectors.toList());
    }
}
