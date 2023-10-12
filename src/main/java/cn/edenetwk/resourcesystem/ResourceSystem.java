package cn.edenetwk.resourcesystem;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
public final class ResourceSystem extends JavaPlugin implements Listener {




    private FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("Eden资源区管理已启用");
        getServer().getPluginManager().registerEvents(this, this);
        loadConfig();
        PluginCommand myCommand = getCommand("resource");
        // 设置指令的描述
        if (myCommand != null) {
            myCommand.setDescription("Eden资源区插件重新加载");
        }
        // 设置指令的执行器（CommandExecutor）
        if (myCommand != null) {
            myCommand.setExecutor(this); // 该插件的主类实现了CommandExecutor接口
        }
        /*
        Bukkit.getAsyncScheduler().runAtFixedRate(this,task->{
            for(Player player : Bukkit.getOnlinePlayers()){
                if(player.getGameMode()!=GameMode.SURVIVAL) continue;
                double absX = Math.abs(player.getLocation().toCenterLocation().getX());
                double absZ = Math.abs(player.getLocation().toCenterLocation().getZ());

                if(absX > RegionSize || absZ > RegionSize){
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    if(!player.hasMetadata("inResource")) {
                        Title title = Title.title(Component.text("您已进入资源区")
                                .color(net.kyori.adventure.text.format.TextColor.color(153, 255, 153)),(Component.text("资源区经常重置请不要留下您的贵重物品")));
                        player.showTitle(title);
                        player.setMetadata("inResource", new FixedMetadataValue(this, true));
                    }
                }else{
                    if(player.hasMetadata("inResource")) {
                        Title title = Title.title(Component.text("您已离开资源区")
                                .color(net.kyori.adventure.text.format.TextColor.color(153, 153, 255)),(Component.text("一起建筑生存吧")));
                        player.showTitle(title);
                        player.removeMetadata("inResource", this);
                    }
                }
            }
        },0,1, TimeUnit.SECONDS);*/
        // Plugin startup logic

    }

    //RegionSize之外区域开服重置

    @EventHandler
    /*public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if((block.getType().toString().contains("SIGN"))&&(Math.abs(block.getLocation().toCenterLocation().getX()) > RegionSize || Math.abs(block.getLocation().toCenterLocation().getZ()) > RegionSize)){
            // 如果玩家尝试放置木牌，取消该事件
            event.setCancelled(true);
            event.getPlayer().sendMessage(Component.text("请不要在资源区放置木牌(锁箱子)哦").color(net.kyori.adventure.text.format.TextColor.color(255, 92, 92)));
        }
    }*/



    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        config = getConfig();
        config.getStringList("allowed-commands");
    }

    @EventHandler
    /*public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        double absX = Math.abs(player.getLocation().toCenterLocation().getX());
        double absZ = Math.abs(player.getLocation().toCenterLocation().getZ());

        if (absX > RegionSize || absZ > RegionSize) {
            String command = event.getMessage().toLowerCase();
            if (!isAllowdCommand(command)) {
                event.setCancelled(true);
                player.sendMessage(Component.text("资源区有些事情是不可以的哦?~ 请输入/resource help 查看可以输入的指令").color(net.kyori.adventure.text.format.TextColor.color(255, 92, 92)));
            }
        }
    }
    */

    /*private boolean isAllowdCommand(String command) {
        List<String> allowedCommands = config.getStringList("allowed-commands");
        String[] parts = command.split(" ");
        return allowedCommands.contains(parts[0]);
    }*/

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("resource")) {
            if(args.length==0){
                sender.sendMessage(Component.text("Eden资源区管理插件by草莓腐竹").color(net.kyori.adventure.text.format.TextColor.color(255, 31, 31)));
            }
            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("reload")){
                    if (sender instanceof Player) {
                        sender.sendMessage("此命令只能从控制台执行.");
                    } else {
                        reloadConfig();
                        loadConfig();
                        getLogger().info("配置文件已重新加载.");
                    }
                }
                if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(config.getStringList("allowed-commands").toString());
                }
                if (args[0].equalsIgnoreCase("renew")) {
                    if (sender instanceof Player) {
                        sender.sendMessage("此命令只能从控制台执行.");
                    } else {
                        RenewSystem.deleteFilesWithCriteria();
                        getLogger().info("资源区已重置.");
                    }
                }
                if (args[0].equalsIgnoreCase("recycle")) {
                    if (sender instanceof Player) {
                        sender.sendMessage("此命令只能从控制台执行.");
                    } else {
                        BackupSystem.backup();
                        getLogger().info("城镇区域已备份.");
                    }
                }
            }
        }
        return true;
    }
}
