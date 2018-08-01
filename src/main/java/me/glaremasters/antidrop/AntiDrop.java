package me.glaremasters.antidrop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiDrop extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (getConfig().getString("blocked-items").contains(event.getItemDrop().getItemStack().getType().toString())) {
            event.setCancelled(event.getPlayer().hasPermission("antidrop.nodrop"));
        }
    }
}
