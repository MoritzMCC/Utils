package de.MoritzMCC.utils.configs;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    List<Config> configs = new ArrayList<>();

    public ConfigManager() {

    }

    public Config createConfig(String name, Plugin plugin) {
        Config config = new Config(name, plugin);
        configs.add(config);
        return config;
    }

    public void set(Config config, String key, Object value) {
        config.set(key, value);
    }
    public Object get(Config config, String key) {
       return config.get(key);
    }
    public void safeConfig(Config config){
        config.save();
    }
    public void safeAllConfigs(){
        configs.forEach(Config::save);
    }
    public Object searchInAllConfigs(String key){
       for (Config config : configs) {
           if(config.get(key) != null){
              return config.get(key);
           }
       }
       throw new RuntimeException("Could not find config with key: " + key);
    }

}
