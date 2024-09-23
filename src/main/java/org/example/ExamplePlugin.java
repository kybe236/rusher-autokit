package org.example;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

/**
 * @author not John200410 but kybe236
 */
@SuppressWarnings("unused")
public class ExamplePlugin extends Plugin {
	
	@Override
	public void onLoad() {
		//creating and registering a new module
		final ExampleModule exampleModule = new ExampleModule();
		RusherHackAPI.getModuleManager().registerFeature(exampleModule);
	}
	
	@Override
	public void onUnload() {
		//why the fuck does this method need to exist
	}
	
}