package by.dreamsoft.interviewproject.service;


import by.dreamsoft.interviewproject.model.SearchHistory;
import by.dreamsoft.interviewproject.repository.SearchHistoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

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
        searchHistory.setFilePath("/home");
        searchHistory.setSearchWord("word");

        service.save(searchHistory);

        Assert.assertNotNull(searchHistory.getDate());
    }

    @Test
    public void testGetAllOrderedByDate() {
        SearchHistory searchHistory1 = new SearchHistory();
        searchHistory1.setId(1);
        searchHistory1.setSearchWord("word");
        searchHistory1.setFilePath("/home");
        searchHistory1.setDate(LocalDateTime.of(2010, 1, 1, 1, 1));

        SearchHistory searchHistory2 = new SearchHistory();
        searchHistory2.setId(2);
        searchHistory2.setSearchWord("word");
        searchHistory2.setFilePath("/home");
        searchHistory2.setDate(LocalDateTime.of(2008, 1, 1, 1, 1));

        SearchHistory searchHistory3 = new SearchHistory();
        searchHistory3.setId(3);
        searchHistory3.setSearchWord("word");
        searchHistory3.setFilePath("/home");
        searchHistory3.setDate(LocalDateTime.of(2019, 1, 1, 1, 1));

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
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setId(1);
        searchHistory.setFilePath("src/test/resources/test_text.txt");
        searchHistory.setSearchWord("error");
        searchHistory.setDate(LocalDateTime.now());

        List<String> rowsWithWord = service.getAllRowsWithWord(searchHistory);

        Assert.assertEquals("error 404", rowsWithWord.get(0));
    }

}
