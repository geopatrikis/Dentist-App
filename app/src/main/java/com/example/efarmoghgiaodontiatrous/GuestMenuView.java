package com.example.efarmoghgiaodontiatrous;

public interface GuestMenuView {

    void showError(String msg);

    void showSearchView(String title, String author);

    void showSearchViewFilters(String region, String specialization);
}
