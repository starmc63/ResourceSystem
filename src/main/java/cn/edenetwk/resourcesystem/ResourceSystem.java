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
        getLogger().info("Eden��Դ������������");
        getServer().getPluginManager().registerEvents(this, this);
        loadConfig();
        PluginCommand myCommand = getCommand("resource");
        // ����ָ�������
        if (myCommand != null) {
            myCommand.setDescription("Eden��Դ��������¼���");
        }
        // ����ָ���ִ������CommandExecutor��
        if (myCommand != null) {
            myCommand.setExecutor(this); // �ò��������ʵ����CommandExecutor�ӿ�
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
                        Title title = Title.title(Component.text("���ѽ�����Դ��")
                                .color(net.kyori.adventure.text.format.TextColor.color(153, 255, 153)),(Component.text("��Դ�����������벻Ҫ�������Ĺ�����Ʒ")));
                        player.showTitle(title);
                        player.setMetadata("inResource", new FixedMetadataValue(this, true));
                    }
                }else{
                    if(player.hasMetadata("inResource")) {
                        Title title = Title.title(Component.text("�����뿪��Դ��")
                                .color(net.kyori.adventure.text.format.TextColor.color(153, 153, 255)),(Component.text("һ���������")));
                        player.showTitle(title);
                        player.removeMetadata("inResource", this);
                    }
                }
            }
        },0,1, TimeUnit.SECONDS);*/
        // Plugin startup logic

    }

    //RegionSize֮�����򿪷�����

    @EventHandler
    /*public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if((block.getType().toString().contains("SIGN"))&&(Math.abs(block.getLocation().toCenterLocation().getX()) > RegionSize || Math.abs(block.getLocation().toCenterLocation().getZ()) > RegionSize)){
            // �����ҳ��Է���ľ�ƣ�ȡ�����¼�
            event.setCancelled(true);
            event.getPlayer().sendMessage(Component.text("�벻Ҫ����Դ������ľ��(������)Ŷ").color(net.kyori.adventure.text.format.TextColor.color(255, 92, 92)));
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
                player.sendMessage(Component.text("��Դ����Щ�����ǲ����Ե�Ŷ?~ ������/resource help �鿴���������ָ��").color(net.kyori.adventure.text.format.TextColor.color(255, 92, 92)));
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
                sender.sendMessage(Component.text("Eden��Դ��������by��ݮ����").color(net.kyori.adventure.text.format.TextColor.color(255, 31, 31)));
            }
            if (args.length == 1) {
                if(args[0].equalsIgnoreCase("reload")){
                    if (sender instanceof Player) {
                        sender.sendMessage("������ֻ�ܴӿ���ִ̨��.");
                    } else {
                        reloadConfig();
                        loadConfig();
                        getLogger().info("�����ļ������¼���.");
                    }
                }
                if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(config.getStringList("allowed-commands").toString());
                }
                if (args[0].equalsIgnoreCase("renew")) {
                    if (sender instanceof Player) {
                        sender.sendMessage("������ֻ�ܴӿ���ִ̨��.");
                    } else {
                        RenewSystem.deleteFilesWithCriteria();
                        getLogger().info("��Դ��������.");
                    }
                }
                if (args[0].equalsIgnoreCase("recycle")) {
                    if (sender instanceof Player) {
                        sender.sendMessage("������ֻ�ܴӿ���ִ̨��.");
                    } else {
                        BackupSystem.backup();
                        getLogger().info("���������ѱ���.");
                    }
                }
            }
        }
        return true;
    }
}
