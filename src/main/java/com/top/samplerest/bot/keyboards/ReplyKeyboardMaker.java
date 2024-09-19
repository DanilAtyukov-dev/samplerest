package com.top.samplerest.bot.keyboards;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReplyKeyboardMaker {
   public ReplyKeyboardMarkup getMenu(){
        KeyboardRow row = new KeyboardRow();

        row.add(new KeyboardButton("Item1"));
        row.add(new KeyboardButton("Item2"));
        row.add(new KeyboardButton("Item3"));
        row.add(new KeyboardButton("Item4"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);

        return replyKeyboardMarkup;
    }
}
