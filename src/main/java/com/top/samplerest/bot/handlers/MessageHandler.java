package com.top.samplerest.bot.handlers;

import com.top.samplerest.bot.keyboards.InlineKeyboardMaker;
import com.top.samplerest.bot.keyboards.ReplyKeyboardMaker;
import com.top.samplerest.model.Commands;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MessageHandler {
    InlineKeyboardMaker inlineKeyboardMaker;
    ReplyKeyboardMaker replyKeyboardMaker;

    MessageHandler(InlineKeyboardMaker inlineKeyboardMaker, ReplyKeyboardMaker replyKeyboardMaker){
        this.inlineKeyboardMaker = inlineKeyboardMaker;
        this.replyKeyboardMaker = replyKeyboardMaker;
    }

    public SendMessage handleMessage(Message message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage(
                message.getChatId().toString(),
                "Привет Мир!"
        );
        //sendMessage.setReplyMarkup(inlineKeyboardMaker.getLang());

        if (message.getText().equals(Commands.KEYBOARD.command)){
            sendMessage.setReplyMarkup(replyKeyboardMaker.getMenu());
        }

        return sendMessage;
    }
}
