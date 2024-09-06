package org.hwabeag.joinmessage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class JoinMessage extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getLogger().info ("JoinMessage 플러그인 로딩완료");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info ("JoinMessage 플러그인 종료되었습니다.");
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        player.sendMessage("당신이 접속했습니다.");
        event.setJoinMessage(name + "님이 접속했습니다.");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player p) {
            if (command.getName().equals("스폰테스트")){
                p.sendMessage("당신은 스폰테스트 명령어를 이용했습니다."); // null
                Location location = Objects.requireNonNull(Bukkit.getWorld("Lobby")).getSpawnLocation();
                p.teleport(location);
                return true;
            } /* else {
                p.sendMessage("당신은 명령어를 잘못사용했습니다.");
                return true;
            } */
            /* if (args.length == 0) {
                return true;
            }
            if (args[0].equalsIgnoreCase("exp")) {
            } */
        }
        return false;
    }


}