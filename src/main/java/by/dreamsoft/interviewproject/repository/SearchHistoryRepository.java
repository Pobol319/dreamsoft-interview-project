package by.dreamsoft.interviewproject.repository;

import by.dreamsoft.interviewproject.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Integer> {
}
