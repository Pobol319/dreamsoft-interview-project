package by.dreamsoft.interviewproject.service;


import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.model.SearchHistoryDto;
import by.dreamsoft.interviewproject.repository.SearchHistoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchHistoryServiceImplTest {

    @Autowired
    private SearchHistoryService service;

    @MockBean
    private SearchHistoryRepository repository;

    @Test
    public void testSave() {
        SearchHistory searchHistory = new SearchHistory();

        service.save(searchHistory);

        verify(repository).save(Mockito.any());
    }

    @Test
    public void testGetAllOrderedByDate() {
        SearchHistory searchHistory1 = new SearchHistory("word", "/home", LocalDateTime.of(2010, 1, 1, 1, 1));
        searchHistory1.setId(1);

        SearchHistory searchHistory2 = new SearchHistory("word", "/home", LocalDateTime.of(2008, 1, 1, 1, 1));
        searchHistory2.setId(2);

        SearchHistory searchHistory3 = new SearchHistory("word", "/home", LocalDateTime.of(2019, 1, 1, 1, 1));
        searchHistory3.setId(3);

        List<SearchHistory> searchHistoryList = new ArrayList<>();
        searchHistoryList.add(searchHistory1);
        searchHistoryList.add(searchHistory2);
        searchHistoryList.add(searchHistory3);

        when(repository.findAll()).thenReturn(searchHistoryList);

        List<SearchHistory> searchHistoryListActual = service.getAllOrderedByDate();

        Assert.assertEquals(searchHistory2, searchHistoryListActual.get(0));
        Assert.assertEquals(searchHistory1, searchHistoryListActual.get(1));
        Assert.assertEquals(searchHistory3, searchHistoryListActual.get(2));
    }

    @Test
    public void testGetAllRowsWithWord() throws IOException {
        SearchHistoryDto searchHistoryDto = new SearchHistoryDto();
        searchHistoryDto.setFilePath("src/test/resources/test_text.txt");
        searchHistoryDto.setSearchWord("error");

        List<String> rowsWithWord = service.getAllRowsWithWord(searchHistoryDto);

        Assert.assertEquals("error 404", rowsWithWord.get(0));
    }

}
