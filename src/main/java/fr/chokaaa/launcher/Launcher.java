package fr.chokaaa.launcher;

import fr.chokaaa.launcher.ui.PanelManager;
import fr.chokaaa.launcher.utils.Helpers;
import fr.flowarg.flowlogger.ILogger;
import fr.flowarg.flowlogger.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application {
    private PanelManager panelManager;
    private static Launcher instance;
    private final ILogger logger;
    private final File LauncherDir = Helpers.generatGamePath("FuFX");

    public Launcher() {
        instance = this;
        this.logger = new Logger("FuFX", new File(this.LauncherDir, "launcher.log"));
        this.LauncherDir.mkdirs();
    }

    @Override
    public void start(Stage stage) {
        this.logger.info("Starting Launcher");
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
    }

    public ILogger getLogger() {
        return logger;
    }

    public static Launcher getInstance() {
        return instance;
    }
}
