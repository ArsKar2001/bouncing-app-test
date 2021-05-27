package karmanchuk.bouncing.ui.models;

import java.util.Collections;
import java.util.List;

public class PagingList {
    PagingList() {
    }

    public static <T> List<T> getPage(List<T> sourceList, int page, int size) {
        if (size <= 0 || page <= 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным: " + size);
        }
        int from = (page - 1) * size;
        if (sourceList.isEmpty() || sourceList.size() <= from) {
            return Collections.emptyList();
        }
        return sourceList.subList(from, Math.min(from + size, sourceList.size()));
    }
}
