package com.github.wickoo.chatterbox;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private ChatterboxMain plugin;

    public ChatListener (ChatterboxMain plugin) {

        this.plugin = plugin;

    }

    @EventHandler
    public void onChat (AsyncPlayerChatEvent event) {

        String message = event.getMessage();
        String rainbowGradient = ChatterUtils.applyRandomRainbowGradient(message, 100);
        String hexMessage = ChatterUtils.translateHexCodes(message);

        event.setMessage(hexMessage);

    }

}
