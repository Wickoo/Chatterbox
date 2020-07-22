package com.github.wickoo.chatterbox;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatterUtils {

    private ChatterUtils () {

    }

    public static final Pattern HEX_PATTERN = Pattern.compile("&#(\\w{5}[0-9a-f])");

    public static String translateHexCodes (String textToTranslate) {

        Matcher matcher = HEX_PATTERN.matcher(textToTranslate);
        StringBuffer buffer = new StringBuffer();

        while(matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
        }

        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());

    }

    public static String applyInfiniteRainbowGradient (String textToMakeRainbow) {

        return applyRainbowGradient(textToMakeRainbow, textToMakeRainbow.toCharArray().length, 0F);
    }

    public static String applyRandomRainbowGradient (String textToMakeRainbow, int rainbowLength) {

        return applyRainbowGradient(textToMakeRainbow, rainbowLength, (float) ThreadLocalRandom.current().nextDouble(0,1));
    }


    public static String applyRainbowGradient (String textToMakeRainbow, int rainbowLength, float startHSBValue) {

        char[] characters = textToMakeRainbow.toCharArray();
        int lettersTotal = characters.length;
        float jumpValue = 1F / (rainbowLength * 1.0F);

        int[] colours = new int[lettersTotal];

        for (int i = 0; i < lettersTotal; i++) {

            colours[i] = Color.HSBtoRGB(jumpValue * i + startHSBValue, 1.0F, 1.0F);
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < characters.length; j++) {

            if (characters[j] == ' ') {
                stringBuilder.append(characters[j]);
                continue;
            }

            stringBuilder.append(ChatColor.of(new Color(colours[j]))).append(characters[j]);

        }


        return stringBuilder.toString();
    }

}
