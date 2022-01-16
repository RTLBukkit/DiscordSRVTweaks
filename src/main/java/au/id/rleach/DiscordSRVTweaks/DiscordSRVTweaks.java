package au.id.rleach.DiscordSRVTweaks;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordReadyEvent;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordSRVTweaks extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        DiscordSRV.api.subscribe(this);
    }

    @Override
    public void onDisable() {
        DiscordUtil.getJda().removeEventListener(this);
        DiscordSRV.api.unsubscribe(this);
    }

    @Subscribe
    public void discordReadyEvent(DiscordReadyEvent event) {
        var jdaListener = new JdaListener(this);
        DiscordUtil.getJda().addEventListener(jdaListener);
    }
}
