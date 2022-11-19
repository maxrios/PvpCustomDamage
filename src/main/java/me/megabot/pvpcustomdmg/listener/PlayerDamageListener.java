package me.megabot.pvpcustomdmg.listener;

import me.megabot.pvpcustomdmg.config.DamageConfig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageListener implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (!isPvp(event)) return;

        double damage = DamageConfig.modifyDamageValue(event.getDamage());
        event.setDamage(damage);
    }

    private boolean isPvp(EntityDamageByEntityEvent event) {
        if (!DamageConfig.isDemoEnabled()) {
            if (!(event.getEntity() instanceof Player)) return false;
        }

        if (!(event.getDamager() instanceof Player)) {
            return (event.getDamager() instanceof Projectile projectile) &&
                    projectile.getShooter() instanceof Player;
        }

        return true;
    }
}