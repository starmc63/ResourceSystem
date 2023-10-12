package cn.edenetwk.resourcesystem;
import java.io.File;
import static org.bukkit.Bukkit.getLogger;

public class RenewSystem {
    //RegionSize之外是资源区 RegionSize之内野外禁止破坏。
    private static final int RegionSize = 65536;
    static void deleteFilesWithCriteria() {
        File worldDirectory = new File("world/region");
        File netherDirectory = new File("world_nether/DIM-1/region");
        File endDirectory = new File("world_the_end/DIM-1/region");
        // 检查目录是否存在
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + "world/region");
            return;
        }
        File[] worldFiles = worldDirectory.listFiles();
        if (worldFiles != null) {
            for (File file : worldFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // 解析文件名，获取mca名称的值
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // 如果mca的绝对值大于128，则删除文件
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除主世界区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除主世界区域" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除主世界区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除主世界区域 " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("文件名无法解析: " + file.getName());
                        }
                    }
                }
            }
        }
        if (!netherDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + "world_nether/DIM-1/region");
            return;
        }

        File[] netherFiles = netherDirectory.listFiles();

        if (netherFiles != null) {
            for (File file : netherFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // 解析文件名，获取mca名称的值
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // 如果mca的绝对值大于128，则删除文件
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除地狱区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除地狱区域" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除地狱区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除地狱区域 " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("文件名无法解析: " + file.getName());
                        }
                    }
                }
            }
        }
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + "world_the_end/DIM-1/region");
            return;
        }

        File[] endFiles = endDirectory.listFiles();

        if (endFiles != null) {
            for (File file : endFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // 解析文件名，获取mca名称的值
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // 如果mca的绝对值大于128，则删除文件
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除末地区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除末地区域" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("已删除末地区域" + file.getName());
                                } else {
                                    getLogger().warning("无法删除末地区域 " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("文件名无法解析: " + file.getName());
                        }
                    }
                }
            }
        }
    }

}

