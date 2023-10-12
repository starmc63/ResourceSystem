package cn.edenetwk.resourcesystem;
import java.io.File;
import static org.bukkit.Bukkit.getLogger;

public class RenewSystem {
    //RegionSize֮������Դ�� RegionSize֮��Ұ���ֹ�ƻ���
    private static final int RegionSize = 65536;
    static void deleteFilesWithCriteria() {
        File worldDirectory = new File("world/region");
        File netherDirectory = new File("world_nether/DIM-1/region");
        File endDirectory = new File("world_the_end/DIM-1/region");
        // ���Ŀ¼�Ƿ����
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + "world/region");
            return;
        }
        File[] worldFiles = worldDirectory.listFiles();
        if (worldFiles != null) {
            for (File file : worldFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // �����ļ�������ȡmca���Ƶ�ֵ
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // ���mca�ľ���ֵ����128����ɾ���ļ�
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ������������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ������������" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ������������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ������������ " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("�ļ����޷�����: " + file.getName());
                        }
                    }
                }
            }
        }
        if (!netherDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + "world_nether/DIM-1/region");
            return;
        }

        File[] netherFiles = netherDirectory.listFiles();

        if (netherFiles != null) {
            for (File file : netherFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // �����ļ�������ȡmca���Ƶ�ֵ
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // ���mca�ľ���ֵ����128����ɾ���ļ�
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ����������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ����������" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ����������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ���������� " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("�ļ����޷�����: " + file.getName());
                        }
                    }
                }
            }
        }
        if (!worldDirectory.exists() || !worldDirectory.isDirectory()) {
            getLogger().warning("ָ��Ŀ¼�����ڻ���Ŀ¼: " + "world_the_end/DIM-1/region");
            return;
        }

        File[] endFiles = endDirectory.listFiles();

        if (endFiles != null) {
            for (File file : endFiles) {
                if (file.isFile() && file.getName().matches(".*\\.(?:mca)")) {
                    // �����ļ�������ȡmca���Ƶ�ֵ
                    String[] parts = file.getName().split("\\.");
                    if (parts.length >= 3) {
                        try {
                            int mcaValue1 = Integer.parseInt(parts[1]);
                            int mcaValue2 = Integer.parseInt(parts[2]);
                            // ���mca�ľ���ֵ����128����ɾ���ļ�
                            if (Math.abs(mcaValue1) > RegionSize/512 || Math.abs(mcaValue2) > RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ��ĩ������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ��ĩ������" + file.getName());
                                }
                            }
                            if (mcaValue1 == RegionSize/512 || mcaValue2 == RegionSize/512) {
                                if (file.delete()) {
                                    getLogger().info("��ɾ��ĩ������" + file.getName());
                                } else {
                                    getLogger().warning("�޷�ɾ��ĩ������ " + file.getName());
                                }
                            }
                        } catch (NumberFormatException e) {
                            getLogger().warning("�ļ����޷�����: " + file.getName());
                        }
                    }
                }
            }
        }
    }

}

