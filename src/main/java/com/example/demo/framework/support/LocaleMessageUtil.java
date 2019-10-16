package com.example.demo.framework.support;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/12 13:51
 */
public class LocaleMessageUtil {

    private static String MESSAGE_RESOURCE = "i18n/messages";

    public static String getMessage(String key, Object... args) {
        // 这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_RESOURCE, locale);
        if (resourceBundle.containsKey(key)) {
            return String.format(locale, resourceBundle.getString(key), args);
        }
        return "";
    }
}
