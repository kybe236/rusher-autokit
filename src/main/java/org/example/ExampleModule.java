package org.example;

import net.minecraft.client.gui.screens.DeathScreen;
import org.rusherhack.client.api.events.client.EventUpdate;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.event.subscribe.Subscribe;
import org.rusherhack.core.setting.NumberSetting;
import org.rusherhack.core.setting.StringSetting;

import java.util.Timer;

/**
 * @author not John200410 but kybe236
 */
public class ExampleModule extends ToggleableModule {

	NumberSetting<Integer> delay = new NumberSetting<>("Delay", "Delay in ms", 1, 0, 10000);
	StringSetting kit = new StringSetting("Kit", "Kit to use", "kybe");

	public ExampleModule() {
		super("AutoKit", "Auto Kit", ModuleCategory.CLIENT);
		this.registerSettings(
				this.delay
		);
	}

	boolean block = false;
	@SuppressWarnings("unused")
	@Subscribe
	private void onUpdate(EventUpdate ignore) {
		if (mc.player == null) return;
		if (block) {
			if (!(mc.screen instanceof DeathScreen || mc.screen instanceof DeathScreen.TitleConfirmScreen)) {
				block = false;
				Timer timer = new Timer();
				timer.schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						mc.player.connection.sendCommand("kit " + kit.getValue());
					}
				}, delay.getValue());
			}
		} else {
			if (mc.screen instanceof DeathScreen || mc.screen instanceof DeathScreen.TitleConfirmScreen) {
				block = true;
			}
		}
	}

}
