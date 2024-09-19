package com.top.samplerest.model;

public enum LangButtons {
    ENG("English", "select_en"),
    RUS("Русский", "select_ru");

    LangButtons(String text, String callback){
        this.text = text;
        this.callback = callback;
    }

    public String text;
    public String callback;
}
