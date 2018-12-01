package com.web.shop.model.enums;

public enum Sorting {
    ASC_NAME("name", "Name (A - Z)"),
    DESC_NAME("name", "Name (Z - A)"),
    ASC_PRICE("price", "Price (Low > High)"),
    DESC_PRICE("price", "Price (Low < High)");

    String sorting;
    String name;

    Sorting(String sorting, String name) {

        this.sorting = sorting;
        this.name = name;
    }

    public String getSorting() {
        return sorting;
    }

    public String getName() {
        return name;
    }
}
