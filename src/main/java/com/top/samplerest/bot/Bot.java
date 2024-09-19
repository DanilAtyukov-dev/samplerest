package com.top.samplerest.bot;


import com.top.samplerest.bot.handlers.CallbackHandler;
import com.top.samplerest.bot.handlers.MessageHandler;
import com.top.samplerest.bot.keyboards.InlineKeyboardMaker;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Bot extends TelegramLongPollingBot {
    String token = "7827462461:AAE6giva9JyczVBZ7BTmmdBcR758HtPGSNE";
    String username = "@sample12341234_bot";
    InlineKeyboardMaker inlineKeyboardMaker;
    CallbackHandler callbackHandler;
    MessageHandler messageHandler;

    Bot(InlineKeyboardMaker inlineKeyboardMaker, CallbackHandler callbackHandler, MessageHandler messageHandler) {
        this.inlineKeyboardMaker = inlineKeyboardMaker;
        this.callbackHandler = callbackHandler;
        this.messageHandler = messageHandler;

        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {

            if (update.hasCallbackQuery()) {
                SendMessage sendMessage = callbackHandler.handleCallback(update.getCallbackQuery());
                execute(sendMessage);
            } else if (update.hasMessage()) {
                Message message = update.getMessage();

                SendMessage sendMessage = messageHandler.handleMessage(message);
                execute(sendMessage);

            }

        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
