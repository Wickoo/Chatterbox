package com.github.wickoo.chatterbox;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatterboxMain extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new ChatListener(this), this);

    }

}
