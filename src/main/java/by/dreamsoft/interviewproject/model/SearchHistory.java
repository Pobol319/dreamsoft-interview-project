package by.dreamsoft.interviewproject.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "search_history")
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_history_id", nullable = false)
    private Integer id;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "search_word", nullable = false)
    private String searchWord;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchHistory that = (SearchHistory) o;
        return id.equals(that.id) &&
                filePath.equals(that.filePath) &&
                searchWord.equals(that.searchWord) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, searchWord, date);
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", searchWord='" + searchWord + '\'' +
                ", date=" + date +
                '}';
    }
}
