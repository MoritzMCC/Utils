package de.MoritzMCC.utils.configs;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {
    private final File file;
    private final YamlConfiguration config;

    public Config(String configName, Plugin plugin) {
        File dir = new File("./plugins/" +plugin.getName() + "/");

        if (!dir.exists()) {
            dir.mkdirs();
        }

        this.file = new File(dir, configName+".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void set(final String key, final Object value) {
        config.set(key, value);
        save();
    }
    public Object get(final String key) {
        return config.get(key);
    }
}

