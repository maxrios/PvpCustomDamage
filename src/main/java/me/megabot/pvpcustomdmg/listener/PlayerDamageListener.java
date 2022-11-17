package me.megabot.pvpcustomdmg.listener;

import me.megabot.pvpcustomdmg.config.DamageConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageListener implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) ||
            !(event.getDamager() instanceof Player)) return;

        double damage = DamageConfig.modifyDamageValue(event.getDamage());
        event.setDamage(damage);
    }
}
