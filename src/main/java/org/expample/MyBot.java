package org.expample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MyBot extends TelegramLongPollingBot{
    String sign = "-";
    double f1nalCourse = 0;
    double f2nalCourse = 0;
    boolean isP = false;

    String s = null;
    boolean isUpdate = false;
    double amount = 0;
    String plata = null;
    public static boolean oplataVerify = false;
    boolean isOplata = false;
    boolean isPlay = false;
    String prew = "";
    double prewDigit = 0;
    public  int BALANCE;
    public static final String PUBLIC_KEY = "sandbox_i52742799786";
    public static final String PRIVATE_KEY = "sandbox_DKfNoJCyLyKFtuxSCckCfr935h14n7aJcLGqL2u4";
    int amountTradersOnline;
    boolean isPay = false;
    boolean isTime = false;
    private HashMap<Long, User> users = new HashMap<>();
    User user;
    public int getAmountTradersOnline() {
        Random random = new Random();
        int min = 800;
        int max = 2000;
        int randomOnline = random.nextInt((max - min) + 1) + min;
        return amountTradersOnline = randomOnline;
    }
    public void onUpdateReceived(Update update) {
        double digit = 0;
        double sum = 0;
        String key = "";
        if (update.hasMessage()) {
            long chat_id = update.getMessage().getChatId();
            user = users.get(chat_id);
            String messageText = update.getMessage().getText();
            SendMessage message = new SendMessage();

            if (user == null) {
                user = new User();
                users.put(chat_id, user);
            }
            message.setChatId(chat_id);

            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

            List<KeyboardRow> keyboard = new ArrayList<>();

            KeyboardRow row1 = new KeyboardRow();
            row1.add(new KeyboardButton("\uD83D\uDCC8 Мой ECN-счёт"));

            KeyboardRow row2 = new KeyboardRow();
            row2.add(new KeyboardButton("\uD83D\uDCB3 Пополнить"));
            row2.add(new KeyboardButton("\uD83D\uDCBC Профиль"));
            row2.add(new KeyboardButton("\uD83D\uDC8E Вывести"));

            keyboard.add(row1);
            keyboard.add(row2);

            keyboardMarkup.setKeyboard(keyboard);

            keyboardMarkup.setOneTimeKeyboard(false);

            if (messageText.equals("\uD83D\uDCC8 Мой ECN-счёт")) {
                String image = "https://exmo.me/wip/_next/static/resources/previewMe-1687c30b4d04a095882e7b4497605e18.png";

                SendPhoto photo = new SendPhoto();
                photo.setChatId(chat_id);
                photo.setCaption("\uD83D\uDCC8Ваш личный ECN счёт!" + System.lineSeparator() + System.lineSeparator() + "\uD83E\uDE99Выберите монетку, в которую хотите инвестировать средства:");
                photo.setPhoto(new InputFile(image));

                InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboardInline = new ArrayList<>();

                List<InlineKeyboardButton> row1Inline = new ArrayList<>();
                InlineKeyboardButton button1 = new InlineKeyboardButton();
                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button1.setText("Bitcoin");
                button2.setText("Ethereum");
                button1.setCallbackData("button1_pressed");
                button2.setCallbackData("button2_pressed");
                row1Inline.add(button1);
                row1Inline.add(button2);
                keyboardInline.add(row1Inline);

                List<InlineKeyboardButton> row2Inline = new ArrayList<>();
                InlineKeyboardButton button3 = new InlineKeyboardButton();
                InlineKeyboardButton button4 = new InlineKeyboardButton();
                button3.setText("Quant");
                button4.setText("Gnosis");
                button3.setCallbackData("button3_pressed");
                button4.setCallbackData("button4_pressed");
                row2Inline.add(button3);
                row2Inline.add(button4);
                keyboardInline.add(row2Inline);

                List<InlineKeyboardButton> row3Inline = new ArrayList<>();
                InlineKeyboardButton button5 = new InlineKeyboardButton();
                InlineKeyboardButton button6 = new InlineKeyboardButton();
                button5.setText("Binance Coin");
                button6.setText("Bitcoin Cash");
                button5.setCallbackData("button5_pressed");
                button6.setCallbackData("button6_pressed");
                row3Inline.add(button5);
                row3Inline.add(button6);
                keyboardInline.add(row3Inline);


                List<InlineKeyboardButton> row4Inline = new ArrayList<>();
                InlineKeyboardButton button7 = new InlineKeyboardButton();
                InlineKeyboardButton button8 = new InlineKeyboardButton();
                button7.setText("Kusama");
                button8.setText("Solana");
                button7.setCallbackData("button7_pressed");
                button8.setCallbackData("button8_pressed");
                row4Inline.add(button7);
                row4Inline.add(button8);
                keyboardInline.add(row4Inline);


                List<InlineKeyboardButton> row5 = new ArrayList<>();
                InlineKeyboardButton button9 = new InlineKeyboardButton();
                InlineKeyboardButton button10 = new InlineKeyboardButton();
                button9.setText("Maker");
                button10.setText("Aave");
                button9.setCallbackData("button9_pressed");
                button10.setCallbackData("button10_pressed");
                row5.add(button9);
                row5.add(button10);
                keyboardInline.add(row5);

                List<InlineKeyboardButton> row6Inline = new ArrayList<>();
                InlineKeyboardButton button11 = new InlineKeyboardButton();
                InlineKeyboardButton button12 = new InlineKeyboardButton();
                button11.setText("Litecoin");
                button12.setText("Digital Cash");
                button11.setCallbackData("button11_pressed");
                button12.setCallbackData("button12_pressed");
                row6Inline.add(button11);
                row6Inline.add(button12);
                keyboardInline.add(row6Inline);

                List<InlineKeyboardButton> row7Inline = new ArrayList<>();
                InlineKeyboardButton button13 = new InlineKeyboardButton();
                InlineKeyboardButton button14 = new InlineKeyboardButton();
                button13.setText("Zcash");
                button14.setText("Monero");
                button13.setCallbackData("button13_pressed");
                button14.setCallbackData("button14_pressed");
                row7Inline.add(button13);
                row7Inline.add(button14);
                keyboardInline.add(row7Inline);

                markupKeyboard.setKeyboard(keyboardInline);
                photo.setReplyMarkup(markupKeyboard);

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (messageText.equals("\uD83D\uDCB3 Пополнить")) {
                SendPhoto sendPhoto = new SendPhoto();
                String img = "https://info.exmo.me/wp-content/uploads/2020/08/%D0%9A%D1%80%D0%B8%D0%BF%D1%82%D0%BE%D0%B2%D0%B0%D0%BB%D1%8E%D1%82%D0%B0-%D1%87%D0%B5%D1%80%D0%B5%D0%B7-%D0%BA%D0%B0%D1%80%D1%82%D1%83.png";
                sendPhoto.setChatId(chat_id);
                sendPhoto.setPhoto(new InputFile(img));
                sendPhoto.setCaption("\uD83D\uDCB2Пополнения счёта:");
                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboardInline = new ArrayList<>();

                List<InlineKeyboardButton> row1Inline = new ArrayList<>();
                InlineKeyboardButton buttonPay = new InlineKeyboardButton();
                buttonPay.setText("\uD83E\uDE99 Пополнить");
                buttonPay.setCallbackData("buttonPay_pressed");
                row1Inline.add(buttonPay);
                keyboardInline.add(row1Inline);
                markup.setKeyboard(keyboardInline);
                sendPhoto.setReplyMarkup(markup);
                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (messageText.equals("\uD83D\uDCBC Профиль") || messageText.equals("/start") || messageText.equals("\uD83D\uDD19 Вернуться")) {
                message.setChatId(chat_id);
                message.setText("\uD83D\uDCBC Мой профиль" + System.lineSeparator() + System.lineSeparator() +
                        "\uD83E\uDD11 Денежный баланс: " + user.getBalance() + System.lineSeparator() +
                        "\uD83D\uDCDD Зарегестрирован: " + user.getDaysSinceRegistration() + System.lineSeparator() +
                        "✅ Успешнные тразакции: " + user.getSuccessfulTransaction() + System.lineSeparator() + System.lineSeparator() +
                        "\uD83D\uDCC8 Кол-во трейдеров онлайн: " + getAmountTradersOnline());
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (isPay) {
                String str = messageText;
                if ((str.matches("\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d\\d")) || (str.matches("\\d\\d")) || (str.matches("\\d"))) {
                    digit = Double.parseDouble(str);
                    if (digit < 700) {
                        System.out.println(user.getUserId());
                        SendMessage messageError = new SendMessage();
                        messageError.setChatId(chat_id);
                        messageError.setText("✖ Сумма меньше минимальной");
                        try {
                            execute(messageError);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(user.getBalance());
                        System.out.println(user.getUserId());
                        isPay = false;
                        SendMessage message1 = new SendMessage();
                        message1.setText("\uD83D\uDCB8");
                        message1.setChatId(chat_id);
                        try {
                            execute(message1);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                        SendMessage message2 = new SendMessage();
                        message2.setChatId(chat_id);
                        key = generateKey("BLI-ZATO:", 10);
                        if (!key.isEmpty()) {
                            prew = key;
                        }
                        if (digit != 0.0) {
                            prewDigit = digit;
                        }
                        message2.setText("\uD83D\uDCE9 Пополнение баланса" + System.lineSeparator() + System.lineSeparator() +
                                "\uD83D\uDCB3 Реквизиты: 5375414143792173" + System.lineSeparator() +
                                "\uD83D\uDCEE Комментарий: " + key + System.lineSeparator() + System.lineSeparator() +
                                "\uD83D\uDEA8 Если вы не можете указать" +
                                " коментарий, отправьте \nчек/скриншот или квитанцию в тех поддержку после оплаты.");
                        try {
                            execute(message2);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }

                        SendMessage message11 = new SendMessage();
                        message11.setChatId(chat_id);
                        message11.setText("Нажмите на кнопку после произведения оплаты, для того чтобы обновить ваш баланс");
                        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> keyboardInline = new ArrayList<>();
                        List<InlineKeyboardButton> row2Inline = new ArrayList<>();
                        InlineKeyboardButton button3 = new InlineKeyboardButton();
                        button3.setText("Подтвердить");
                        button3.setCallbackData("button_oplata");
                        row2Inline.add(button3);
                        keyboardInline.add(row2Inline);
                        markupKeyboard.setKeyboard(keyboardInline);
                        message11.setReplyMarkup(markupKeyboard);

                        try {
                            execute(message11);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } else if (isPlay) {
                String str = messageText;
                System.out.println(isPlay);
                if ((str.matches("\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d\\d")) || (str.matches("\\d\\d")) || (str.matches(("\\d")))) {
                    amount = Double.parseDouble(str);
                    System.out.println(amount + " <= " + user.getBalance());
                    if (amount <= user.getBalance()) {
                        if (amount > 700) {
                            InlineKeyboardMarkup miniMarkup = new InlineKeyboardMarkup();
                            List<List<InlineKeyboardButton>> miniKeyboard = new ArrayList<>();

                            List<InlineKeyboardButton> miniRow1 = new ArrayList<>();
                            InlineKeyboardButton buttonM1 = new InlineKeyboardButton();
                            buttonM1.setText("Вверх");
                            buttonM1.setCallbackData("up");
                            miniRow1.add(buttonM1);

                            InlineKeyboardButton buttonM2 = new InlineKeyboardButton();
                            buttonM2.setText("Вниз");
                            buttonM2.setCallbackData("down");
                            miniRow1.add(buttonM2);
                            miniKeyboard.add(miniRow1);

                            List<InlineKeyboardButton> miniRow2 = new ArrayList<>();
                            InlineKeyboardButton buttonM3 = new InlineKeyboardButton();
                            buttonM3.setText("Без изменений");
                            buttonM3.setCallbackData("unchange");
                            miniRow2.add(buttonM3);
                            miniKeyboard.add(miniRow2);
                            miniMarkup.setKeyboard(miniKeyboard);
                            SendMessage message111 = new SendMessage();
                            message111.setParseMode("HTML");
                            message111.setChatId(chat_id);
                            message111.setText("Куда пойдёт курс актива? " + System.lineSeparator() + System.lineSeparator() + "Коэффициенты: " + System.lineSeparator() +
                                    "Повышение - <b>х2</b>" + System.lineSeparator() + "Без изменений - <b>х10</b>" + System.lineSeparator() + "Снижение - <b>х2</b>");
                            message111.setReplyMarkup(miniMarkup);
                            try {
                                execute(message111);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            SendMessage messageError = new SendMessage();
                            messageError.setChatId(chat_id);
                            messageError.setText("✖ Сумма меньше минимальной");
                            try {
                                execute(messageError);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        SendMessage messageError = new SendMessage();
                        messageError.setChatId(chat_id);
                        messageError.setText("✖ У вас недостаточно денег на балансе");
                        try {
                            execute(messageError);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    isPlay = false;
                }
            } else if (messageText.equals("\uD83D\uDC8E Вывести")) {
                System.out.println(222);
                isP = true;
                SendMessage message1 = new SendMessage();
                message1.setText("\uD83D\uDCB0Введите сумму вывода: ");
                message1.setChatId(chat_id);
                try {
                    execute(message1);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }else if(isP){
                String str = messageText;
                if ((str.matches("\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d")) || (str.matches("\\d\\d\\d\\d\\d")) || (str.matches("\\d\\d")) || (str.matches("\\d"))) {
                    System.out.println(1111);
                    sum = Double.parseDouble(str);
                    if (sum > user.getBalance()) {
                        System.out.println(user.getUserId());
                        SendMessage messageError = new SendMessage();
                        messageError.setChatId(chat_id);
                        messageError.setText("✖ Недостаточно денег на балансе");
                        try {
                            execute(messageError);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (sum <= user.getBalance()) {
                        SendMessage message2 = new SendMessage();
                        message2.setChatId(chat_id);
                        message2.setText("Спасибо что воспользовались нашей финансовой пирамидой! Ожидайте выплат, это может занять несколько часов!");
                        try {
                            execute(message2);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    isP = false;
                }
            }
        }else if (update.hasCallbackQuery()) {


            String callbackData = update.getCallbackQuery().getData();
            SendMessage message1 = new SendMessage();
            message1.setChatId(update.getCallbackQuery().getMessage().getChatId());
            if (callbackData.equals("button1_pressed")) {
                isPlay = true;

                s = "BTC";
                cryptoCoin(s, message1);
            } else if (callbackData.equals("button2_pressed")) {
                isPlay = true;
                s = "ETH";

                cryptoCoin(s, message1);
            } else if (callbackData.equals("button3_pressed")) {
                isPlay = true;
                s = "QNT";
                cryptoCoin(s, message1);


            } else if (callbackData.equals("button4_pressed")) {
                isPlay = true;

                cryptoCoin("GNO", message1);

            } else if (callbackData.equals("button5_pressed")) {
                isPlay = true;
                cryptoCoin("BNB", message1);

            } else if (callbackData.equals("button6_pressed")) {
                isPlay = true;

                cryptoCoin("BCH", message1);

            } else if (callbackData.equals("button7_pressed")) {
                isPlay = true;

                cryptoCoin("KSM", message1);

            } else if (callbackData.equals("button8_pressed")) {
                isPlay = true;

                cryptoCoin("SOL", message1);

            } else if (callbackData.equals("button9_pressed")) {
                isPlay = true;


                cryptoCoin("MKR", message1);

            } else if (callbackData.equals("button10_pressed")) {
                isPlay = true;

                cryptoCoin("AAVE", message1);

            } else if (callbackData.equals("button11_pressed")) {
                isPlay = true;

                cryptoCoin("LTC", message1);

            } else if (callbackData.equals("button12_pressed")) {
                isPlay = true;

                cryptoCoin("DASH", message1);

            } else if (callbackData.equals("button13_pressed")) {
                isPlay = true;

                cryptoCoin("ZEC", message1);

            } else if (callbackData.equals("button14_pressed")) {
                isPlay = true;

                cryptoCoin("XMR", message1);

            } else if (callbackData.equals("button1_update")) {
                cryptoCoin("BTC", message1);

            } else if (callbackData.equals("buttonPay_pressed")) {
                SendMessage message = new SendMessage();
                message.setChatId((update.getCallbackQuery().getMessage().getChatId()));
                message.setText("\uD83D\uDCB8 Введите сумму пополнения:" + System.lineSeparator() +
                        System.lineSeparator() + "• Минимальная сумма пополнения: 700 UAH");
                isPay = true;
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (callbackData.equals("button_oplata")) {
                String token = "uj1Wzl1z3REjih_9kWJDcJ_6Bx7SnsEhPy1YcoE9Ww2w";
                String accountId = "_TzcbgtpAzEJm0CJ8r-35A";
                long from = Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond(); // начало периода в Unix-времени
                long to = Instant.now().getEpochSecond(); // конец периода в Unix-времени

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(String.format("https://api.monobank.ua/personal/statement/%s/%d/%d", accountId, from, to)))
                        .setHeader("X-Token", token)
                        .build();
                System.out.println(key + "KEY");

                String finalKey = prew;
                System.out.println(finalKey + "FINAL KEY");
                System.out.println(finalKey);
                double finalDigit = prewDigit;
                User finalUser = user;
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenAccept(response -> {
                            JSONArray statement = new JSONArray(response);
                            for (int i = 0; i < 1; i++) {
                                JSONObject transaction = statement.getJSONObject(i);
                                String comment = null;
                                try {
                                    comment = transaction.getString("comment");
                                } catch (JSONException e) {
                                    comment = "Error: comment isEmpty";
                                }
                                double amount = transaction.getDouble("amount") / 100.0;
                                System.out.println(comment + "=" + finalKey + " and " + finalDigit + "=" + amount);

                                System.out.println(isOplata);
                                if (user.getPaymentComment().isEmpty()) {
                                    if (isOplata) {
                                        //oplata(comment, finalKey, finalDigit, amount, finalUser);
                                        System.out.println(finalKey);
                                        user.setComment(finalKey);
                                        user.setDigit(finalDigit);
                                        if ((comment.equals(user.getPaymentComment()) && (user.getDigit() == amount))) {
                                            finalUser.addBalance(user.getDigit());
                                            user.setComment("");
                                            user.setDigit(0);
                                        }
                                    }
                                    //System.out.println("Comment: " + comment + ", Amount: " + amount);
                                    System.out.println("Баланс:" + finalUser.getBalance());
                                }
                            }
                        })
                        .join();
            } else if (callbackData.equals("up") || callbackData.equals("down") || callbackData.equals("unchange")) {
                SendMessage messagep = new SendMessage();
                messagep.setChatId(update.getCallbackQuery().getMessage().getChatId());
                messagep.setText("⌚ Время ожидания:");
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                List<InlineKeyboardButton> row1 = new ArrayList<>();
                List<InlineKeyboardButton> row2 = new ArrayList<>();
                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("10 секунд");
                button1.setCallbackData("sec10");
                row1.add(button1);
                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("30 секунд");
                button2.setCallbackData("sec30");
                row1.add(button2);
                InlineKeyboardButton button3 = new InlineKeyboardButton();
                button3.setText("60 секунд");
                button3.setCallbackData("sec60");
                row2.add(button3);
                keyboard.add(row1);
                keyboard.add(row2);


                inlineKeyboardMarkup.setKeyboard(keyboard);
                messagep.setReplyMarkup(inlineKeyboardMarkup);
                try {
                    execute(messagep);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (callbackData.equals("sec10")) {
                int seconds = 10;
                SendMessage message = new SendMessage();
                message.setText("⌛ Ожидайте 10 секунд");
                message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                Thread timerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(seconds * 1000);
/*                            SendMessage m = new SendMessage();
                            m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            cryptoText(s, m);*/
                            SendMessage m1 = new SendMessage();
                            m1.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            if (f2nalCourse > f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse < f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse == f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            }
                            execute(m1);
                        } catch (InterruptedException e) {
                            System.out.println("Таймер прерван!");
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                timerThread.start();
            } else if (callbackData.equals("sec30")) {
                int seconds = 30;
                SendMessage message = new SendMessage();
                message.setText("⌛ Ожидайте 30 секунд");
                message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                Thread timerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(seconds * 1000);
/*                            SendMessage m = new SendMessage();
                            m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            cryptoText(s, m);*/
                            SendMessage m1 = new SendMessage();
                            m1.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            if (f2nalCourse > f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse < f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse == f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            }
                            execute(m1);
                        } catch (InterruptedException e) {
                            System.out.println("Таймер прерван!");
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                timerThread.start();
            } else if (callbackData.equals("sec60")) {
                int seconds = 60;
                SendMessage message = new SendMessage();
                message.setText("⌛ Ожидайте 60 секунд");
                message.setChatId(update.getCallbackQuery().getMessage().getChatId());
                Thread timerThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(seconds * 1000);
                            /*SendMessage m = new SendMessage();
                            m.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            cryptoText(s, m);*/
                            SendMessage m1 = new SendMessage();
                            m1.setChatId(update.getCallbackQuery().getMessage().getChatId());
                            if (f2nalCourse > f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse < f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            } else if (f2nalCourse == f1nalCourse) {
                                m1.setText("Баланс обновлён, вам начислена сумма х2 от ставки");
                                user.addBalance(amount * 2);
                            }
                            execute(m1);
                        } catch (InterruptedException e) {
                            System.out.println("Таймер прерван!");
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                timerThread.start();
            }
        }
    }

    // метод для отправки сообщения
    public String cryptoCoin(String nameCrypt, SendMessage message) {
        String apiKey = "c6d66629-a148-4c63-8e88-0bd5e294bcfd";
        message.setParseMode("HTML");
        try {
            URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" + nameCrypt); // URL для получения курса биткоина
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-CMC_PRO_API_KEY", apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObj = new JSONObject(response.toString());
            JSONObject btcObj = jsonObj.getJSONObject("data").getJSONObject(nameCrypt);
            double btcPrice1 = btcObj.getJSONObject("quote").getJSONObject("USD").getDouble("price");
            //DecimalFormat df = new DecimalFormat("0.00");
            //String btcPrice = df.format(btcPrice1);
            String b = String.valueOf(btcPrice1);
            String btcPrice = b.replace(',', '.');
            message.setText("\uD83C\uDF10 Введите сумму, которую вы хотите инвестировать." +
                    System.lineSeparator() + System.lineSeparator() +
                    "Минимальная сумма инвестиций - <b>700 UAH</b>" + System.lineSeparator() + System.lineSeparator()
                    + "Курс монеты" + " <b>" + btcPrice + "$</b>");
            execute(message);
            f1nalCourse = Double.parseDouble(btcPrice);
            return null;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String cryptoText(String nameCrypt, SendMessage message) {
        String apiKey = "c6d66629-a148-4c63-8e88-0bd5e294bcfd";
        message.setParseMode("HTML");
        try {
            URL url = new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" + nameCrypt); // URL для получения курса биткоина
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-CMC_PRO_API_KEY", apiKey);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObj = new JSONObject(response.toString());
            JSONObject btcObj = jsonObj.getJSONObject("data").getJSONObject(nameCrypt);
            double btcPrice1 = btcObj.getJSONObject("quote").getJSONObject("USD").getDouble("price");
            String b = String.valueOf(btcPrice1);
            String btcPrice = b.replace(',', '.');
            message.setText("\uD83C\uDF10 Курс монеты" + " <b>" + btcPrice + "$</b>");
            execute(message);
            f2nalCourse = Double.parseDouble(btcPrice);

            return null;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String generateKey(String prefix, int numDigits) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < numDigits; i++) {
            sb.append(random.nextInt(10)); // генерируем случайную цифру от 0 до 9
        }
        return sb.toString();
    }
    public static void oplata(String comment, String finalKey, double finalDigit, double amount, User finalUser){
        System.out.println(finalKey);
        System.out.println(comment + "=" + finalKey + " and " + finalDigit + "=" + amount);
        if ((comment.equals(finalKey) && (finalDigit == amount))) {
            finalUser.addBalance(finalDigit);
        }
    }



    @Override
    public String getBotUsername() {
        return "cryptoEx4ange_bot";
    }
    @Override
    public String getBotToken() {
        return "5894412154:AAGUIwk4UgKkqctak6DKUHYj7izUiKE5yBs";
    }
}
