package by.dreamsoft.interviewproject.service;

import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.model.SearchHistoryDto;
import by.dreamsoft.interviewproject.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
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
        searchHistoryList.sort(Comparator.comparing(SearchHistory::getDate));
        return searchHistoryList;
    }

    @Override
    public void save(SearchHistory searchHistory) {
        repository.save(searchHistory);
    }

    @Override
    public List<String> getAllRowsWithWord(SearchHistoryDto searchHistoryDto) throws IOException {
        SearchHistory searchHistory = new SearchHistory(searchHistoryDto.getFilePath(), searchHistoryDto.getSearchWord(), LocalDateTime.now());
        save(searchHistory);

        String file = searchHistory.getFilePath();
        String word = searchHistory.getSearchWord();

        return Files.lines(Paths.get(file))
                .map(String::trim)
                .filter(p -> p.contains(word))
                .collect(Collectors.toList());
    }
}
