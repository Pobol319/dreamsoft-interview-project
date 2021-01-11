package by.dreamsoft.interviewproject.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class SearchHistoryDto {
    @NotBlank(message = "incorrect value for filePath")
    private String filePath;
    @NotBlank(message = "incorrect value for searchWord")
    private String searchWord;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchHistoryDto that = (SearchHistoryDto) o;
        return filePath.equals(that.filePath) &&
                searchWord.equals(that.searchWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, searchWord);
    }

    @Override
    public String toString() {
        return "SearchHistoryDto{" +
                "filePath='" + filePath + '\'' +
                ", searchWord='" + searchWord + '\'' +
                '}';
    }
}
