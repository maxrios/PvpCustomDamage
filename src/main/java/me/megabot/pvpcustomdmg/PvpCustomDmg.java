package me.megabot.pvpcustomdmg;

import me.megabot.pvpcustomdmg.executor.DamageConfigExecutor;
import me.megabot.pvpcustomdmg.listener.PlayerDamageListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PvpCustomDmg extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        getServer().getPluginCommand("dmg-control").setExecutor(new DamageConfigExecutor());
    }

    @Override
    public void onDisable() {
    }
}
