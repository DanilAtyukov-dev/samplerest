package com.top.samplerest.bot.keyboards;

import com.top.samplerest.model.LangButtons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineKeyboardMaker {
   public InlineKeyboardMarkup getLang(){
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> row = new ArrayList<>();
        row.add(
                getButton(LangButtons.RUS.text, LangButtons.RUS.callback)
        );

        row.add(
                getButton(LangButtons.ENG.text, LangButtons.ENG.callback)
        );
        markup.setKeyboard(row);

        return markup;
    }


    List<InlineKeyboardButton> getButton(String text, String callback){
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callback);

        List<InlineKeyboardButton> list = new ArrayList();
        list.add(button);
        return list;
    }
}
