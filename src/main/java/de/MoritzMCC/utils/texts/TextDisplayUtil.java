package de.MoritzMCC.utils.texts;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.TextDisplay;

public class TextDisplayUtil {
    org.bukkit.entity.TextDisplay textDisplay;

    public TextDisplayUtil(Location location){
        org.bukkit.entity.TextDisplay textDisplay = Bukkit.getServer().getWorld(location.getWorld().getUID()).spawn(location, org.bukkit.entity.TextDisplay.class);
    }
    public TextDisplayUtil setText(String text){
        textDisplay.setText(text);
         return this;
    }
    public TextDisplayUtil setBackgroundColor(Color color){
        textDisplay.setBackgroundColor(color);
        return this;
    }
    public TextDisplayUtil setShadowed(Boolean shadowed){
        textDisplay.setShadowed(shadowed);
        return this;
    }
    public TextDisplayUtil setGravity(boolean gravity){
        textDisplay.setGravity(gravity);
        return this;
    }

    public TextDisplayUtil setGlowing(Boolean glowing){
        textDisplay.setGlowing(glowing);
        return this;
    }
    public TextDisplay create(){
        return textDisplay;
    }
}
