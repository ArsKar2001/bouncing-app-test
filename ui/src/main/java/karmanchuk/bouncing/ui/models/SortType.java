package karmanchuk.bouncing.ui.models;

public enum SortType {
    NONE("Без сортировки"),
    ASK("По возрастанию"),
    DESK("По убыванию");

    private final String val;

    SortType(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    @Override
    public String toString() {
        return val;
    }
}
