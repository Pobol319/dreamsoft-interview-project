package by.dreamsoft.interviewproject.comparator;

import by.dreamsoft.interviewproject.model.SearchHistory;

import java.util.Comparator;

public class SearchHistoryComparator implements Comparator<SearchHistory> {

    @Override
    public int compare(SearchHistory o1, SearchHistory o2) {
        return o1.getDate().compareTo(o2.getDate());
    }

}
