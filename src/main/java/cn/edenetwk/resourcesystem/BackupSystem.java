package cn.edenetwk.resourcesystem;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import static org.bukkit.Bukkit.getLogger;

public class BackupSystem {
    static void backup() {

        //====================�����籸��====================

        File worldDirectory = new File("world");
        File townyWorldDirectory = new File("plugins/Towny/data/townblocks/world");
        File worldBackupDirectory = new File ("Backups/world");
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + worldDirectory.getName());
            return;
        }
        if (!townyWorldDirectory.exists() || !townyWorldDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + townyWorldDirectory.getName());
            return;
        }
        if(worldBackupDirectory.exists()) {
            deleteFolderAndContents(worldBackupDirectory);
            System.out.println("worldǰ�����ѱ�ɾ��");
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
                                System.out.println("�������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("�������������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("�������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("�������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("�������������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("�������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                    }
                }
            }
        }

        //====================��������====================

        File netherDirectory = new File("world_nether/DIM-1");
        File townynetherDirectory = new File("plugins/Towny/data/townblocks/world_nether");
        File netherBackupDirectory = new File ("Backups/world_nether/DIM-1");
        if (!netherDirectory.exists() || !netherDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + netherDirectory.getName());
            return;
        }
        if (!townynetherDirectory.exists() || !townynetherDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + townynetherDirectory.getName());
            return;
        }
        if(netherBackupDirectory.exists()) {
            deleteFolderAndContents(netherBackupDirectory);
            System.out.println("netherǰ�����ѱ�ɾ��");
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
                                System.out.println("������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("������������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("������������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                    }
                }
            }
        }

        //====================ĩ�ر���====================

        File endDirectory = new File("world_the_end/DIM1");
        File townyendDirectory = new File("plugins/Towny/data/townblocks/world_the_end");
        File endBackupDirectory = new File ("Backups/world_the_end/DIM1");
        if (!endDirectory.exists() || !endDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + endDirectory.getName());
            return;
        }
        if (!townyendDirectory.exists() || !townyendDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + townyendDirectory.getName());
            return;
        }
        if(endBackupDirectory.exists()) {
            deleteFolderAndContents(endBackupDirectory);
            System.out.println("endǰ�����ѱ�ɾ��");
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
                                System.out.println("ĩ�س�������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������ĩ�س�������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("ĩ�س�������"+fileName+"���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("ĩ�س�������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������ĩ�س�������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("ĩ�س�������"+fileName+"���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                    }
                }
            }
        }

        //====================Home���򱸷�====================

        /*Connection connection = null;
        try {
            // ���ӵ�SQLite���ݿ�
            connection = DriverManager.getConnection("jdbc:sqlite:plugins/HuskHomes/HuskHomesData.db");

            // ����һ��Statement����
            Statement statement0 = connection.createStatement();
            Statement statement1 = connection.createStatement();

            // ִ�в�ѯ���
            String query = "SELECT * FROM huskhomes_saved_positions";
            ResultSet resultSet0 = statement0.executeQuery(query);

            // ������ѯ���
            while (resultSet0.next()) {
                int positionID = resultSet0.getInt("position_id");
                // �����ﴦ��ÿһ������
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
                                System.out.println("������Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������������Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("������Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("������Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������������Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("������Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
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
                                System.out.println("����Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("����������Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("����Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("����Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("����������Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("����Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
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
                                System.out.println("ĩ��Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������ĩ��Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("ĩ��Home���� ("+x+","+z+") ���ڵ������region:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
                        }
                        if (!destinationEntities.exists()) {
                            try {
                                Path sourcePath = sourceEntities.toPath();
                                Path destinationPath = destinationEntities.toPath();
                                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("ĩ��Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"���ݳɹ�");
                            } catch (IOException e) {
                                System.err.println("������ĩ��Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"����ʧ�ܣ�����");
                            }
                        } else {
                            System.out.println("ĩ��Home���� ("+x+","+z+") ���ڵ������entities:"+"r."+regionX+"."+regionZ+".mca"+"�Ѿ����ݣ�����������α���");
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
                    // �ݹ�ɾ�����ļ��м�������
                    deleteFolderAndContents(file);
                } else {
                    file.delete(); // ɾ���ļ�
                }
            }
        }
    }
}
