package by.dreamsoft.interviewproject.comparator;

import by.dreamsoft.interviewproject.model.SearchHistory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchHistoryComparatorTests {

    private SearchHistoryComparator comparator;
    private SearchHistory history1;
    private SearchHistory history2;
    private SearchHistory history3;

    @Before
    public void setUp() {
        comparator = new SearchHistoryComparator();

        history1 = new SearchHistory();
        history1.setDate(LocalDateTime.of(2010, 1, 1, 1, 1));

        history2 = new SearchHistory();
        history2.setDate(LocalDateTime.of(2010, 1, 1, 1, 1));

        history3 = new SearchHistory();
        history3.setDate(LocalDateTime.of(2011, 1, 1, 1, 1));

    }

    @Test
    public void testCompareExpectZero() {
        int actualResult = comparator.compare(history1, history2);

        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void testCompareExpectOne() {
        int actualResult = comparator.compare(history3, history2);

        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void testCompareExpectMinusOne() {
        int actualResult = comparator.compare(history2, history3);

        Assert.assertEquals(-1, actualResult);
    }

}
