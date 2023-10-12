package cn.edenetwk.resourcesystem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import static org.bukkit.Bukkit.getLogger;

public class BackupSystem {
    static void backup() {

        //====================主世界备份====================

        File worldDirectory = new File("world");
        File townyWorldDirectory = new File("plugins/Towny/data/townblocks/world");
        File worldBackupDirectory = new File ("Backups/world");
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + worldDirectory.getName());
            return;
        }
        if (!townyWorldDirectory.exists() || !townyWorldDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + townyWorldDirectory.getName());
            return;
        }
        if(worldBackupDirectory.exists()) {
            deleteFolderAndContents(worldBackupDirectory);
            System.out.println("world前备份已被删除");
        }
        File[] townyWorldFiles = townyWorldDirectory.listFiles();
        if (townyWorldFiles != null) {
            new File(worldBackupDirectory+"/region").mkdirs();
            new File(worldBackupDirectory+"/entities").mkdirs();
            for (File file : townyWorldFiles) {
                String fileName = file.getName();
                if (fileName.matches(".*\\.(?:data)")) {
                    String[] parts = fileName.split("_");
                    if (parts.length >= 3) {
                        int regionX = (int) Math.floor(Double.parseDouble(parts[0])/32);
                        int regionZ = (int) Math.floor(Double.parseDouble(parts[1])/32);
                        File sourceRegion = new File(worldDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(worldBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(worldDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(worldBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("主世界城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！主世界城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("主世界城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("主世界城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！主世界城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("主世界城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                    }
                }
            }
        }

        //====================地狱备份====================

        File netherDirectory = new File("world_nether/DIM-1");
        File townynetherDirectory = new File("plugins/Towny/data/townblocks/world_nether");
        File netherBackupDirectory = new File ("Backups/world_nether/DIM-1");
        if (!netherDirectory.exists() || !netherDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + netherDirectory.getName());
            return;
        }
        if (!townynetherDirectory.exists() || !townynetherDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + townynetherDirectory.getName());
            return;
        }
        if(netherBackupDirectory.exists()) {
            deleteFolderAndContents(netherBackupDirectory);
            System.out.println("nether前备份已被删除");
        }
        File[] townynetherFiles = townynetherDirectory.listFiles();
        if (townynetherFiles != null) {
            new File(netherBackupDirectory+"/region").mkdirs();
            new File(netherBackupDirectory+"/entities").mkdirs();
            for (File file : townynetherFiles) {
                String fileName = file.getName();
                if (fileName.matches(".*\\.(?:data)")) {
                    String[] parts = fileName.split("_");
                    if (parts.length >= 3) {
                        int regionX = (int) Math.floor(Double.parseDouble(parts[0])/32);
                        int regionZ = (int) Math.floor(Double.parseDouble(parts[1])/32);
                        File sourceRegion = new File(netherDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(netherBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(netherDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(netherBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("地狱城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！地狱城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("地狱城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("地狱城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！地狱城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("地狱城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                    }
                }
            }
        }

        //====================末地备份====================

        File endDirectory = new File("world_the_end/DIM1");
        File townyendDirectory = new File("plugins/Towny/data/townblocks/world_the_end");
        File endBackupDirectory = new File ("Backups/world_the_end/DIM1");
        if (!endDirectory.exists() || !endDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + endDirectory.getName());
            return;
        }
        if (!townyendDirectory.exists() || !townyendDirectory.isDirectory()) {
            getLogger().warning("指定目录不存在或不是目录: " + townyendDirectory.getName());
            return;
        }
        if(endBackupDirectory.exists()) {
            deleteFolderAndContents(endBackupDirectory);
            System.out.println("end前备份已被删除");
        }
        File[] townyendFiles = townyendDirectory.listFiles();
        if (townyendFiles != null) {
            new File(endBackupDirectory+"/region").mkdirs();
            new File(endBackupDirectory+"/entities").mkdirs();
            for (File file : townyendFiles) {
                String fileName = file.getName();
                if (fileName.matches(".*\\.(?:data)")) {
                    String[] parts = fileName.split("_");
                    if (parts.length >= 3) {
                        int regionX = (int) Math.floor(Double.parseDouble(parts[0])/32);
                        int regionZ = (int) Math.floor(Double.parseDouble(parts[1])/32);
                        File sourceRegion = new File(endDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(endBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(endDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(endBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("末地城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！末地城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("末地城镇区块"+fileName+"所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("末地城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！末地城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("末地城镇区块"+fileName+"所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                    }
                }
            }
        }

        //====================Home区域备份====================

        /*Connection connection = null;
        try {
            // 连接到SQLite数据库
            connection = DriverManager.getConnection("jdbc:sqlite:plugins/HuskHomes/HuskHomesData.db");

            // 创建一个Statement对象
            Statement statement0 = connection.createStatement();
            Statement statement1 = connection.createStatement();

            // 执行查询语句
            String query = "SELECT * FROM huskhomes_saved_positions";
            ResultSet resultSet0 = statement0.executeQuery(query);

            // 遍历查询结果
            while (resultSet0.next()) {
                int positionID = resultSet0.getInt("position_id");
                // 在这里处理每一行数据
                ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM huskhomes_position_data WHERE id = "+positionID);
                switch (resultSet1.getString("world_name")){
                    case "world": {
                        double x = resultSet1.getDouble("x");
                        double z = resultSet1.getDouble("z");
                        int regionX = (int) Math.floor(x/512);
                        int regionZ = (int) Math.floor(z/512);
                        File sourceRegion = new File(worldDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(worldBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(worldDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(worldBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("主世界Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！主世界Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("主世界Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("主世界Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！主世界Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("主世界Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        break;
                    }
                    case "world_nether":{
                        double x = resultSet1.getDouble("x");
                        double z = resultSet1.getDouble("z");
                        int regionX = (int) Math.floor(x/512);
                        int regionZ = (int) Math.floor(z/512);
                        File sourceRegion = new File(netherDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(netherBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(netherDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(netherBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("地狱Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！地狱Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("地狱Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("地狱Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！地狱Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("地狱Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        break;
                    }
                    case "world_the_end":{
                        double x = resultSet1.getDouble("x");
                        double z = resultSet1.getDouble("z");
                        int regionX = (int) Math.floor(x/512);
                        int regionZ = (int) Math.floor(z/512);
                        File sourceRegion = new File(endDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File destinationRegion = new File(endBackupDirectory+"/region", "r."+regionX+"."+regionZ+".mca");
                        File sourceEntities = new File(endDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        File destinationEntities = new File(endBackupDirectory+"/entities", "r."+regionX+"."+regionZ+".mca");
                        if (!destinationRegion.exists()) {
                            try {
                                Path sourcePath = sourceRegion.toPath();
                                Path destinationPath = destinationRegion.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("末地Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！末地Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("末地Home坐标 ("+x+","+z+") 所在的区域的region:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("末地Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份成功");
                            } catch (IOException e) {
                                System.err.println("！！！末地Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"备份失败！！！");
                            }
                        } else {
                            System.out.println("末地Home坐标 ("+x+","+z+") 所在的区域的entities:"+"r."+regionX+"."+regionZ+".mca"+"已经备份！！！无需二次备份");
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }
    public static void deleteFolderAndContents(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归删除子文件夹及其内容
                    deleteFolderAndContents(file);
                } else {
                    file.delete(); // 删除文件
                }
            }
        }
    }
}
