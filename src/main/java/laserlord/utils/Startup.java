package laserlord.utils;

import org.bukkit.plugin.java.JavaPlugin;

public final class Startup extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("wc").setExecutor(new UtilsCommandExecutor(this));
        this.getCommand("rc").setExecutor(new UtilsCommandExecutor(this));
        this.getCommand("gm1").setExecutor(new UtilsCommandExecutor(this));
        this.getCommand("gm0").setExecutor(new UtilsCommandExecutor(this));
        this.getCommand("heal").setExecutor(new UtilsCommandExecutor(this));
        this.getCommand("feed").setExecutor(new UtilsCommandExecutor(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
