package com.quadient.academy.cache;

final public class ExpensiveObject {

    private String id;

    public ExpensiveObject(String id) {
        if (id == null) {
            throw new NullPointerException("id");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpensiveObject that = (ExpensiveObject) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ExpensiveObject{" +
                "id='" + id + '\'' +
                '}';
    }
}
