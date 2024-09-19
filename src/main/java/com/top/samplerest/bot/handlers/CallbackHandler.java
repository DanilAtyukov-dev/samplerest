package com.top.samplerest.bot.handlers;

import com.top.samplerest.model.LangButtons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

@Component
public class CallbackHandler {

    public SendMessage handleCallback(CallbackQuery callbackQuery){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(callbackQuery.getMessage().getChatId().toString());

       String callbackData = callbackQuery.getData();

       if (Objects.equals(callbackData, LangButtons.ENG.callback)){
            sendMessage.setText("Выбран английский");
       } else if(Objects.equals(callbackData, LangButtons.RUS.callback)){
            sendMessage.setText("Выбран русский");
       }

        return sendMessage;
    }
}
