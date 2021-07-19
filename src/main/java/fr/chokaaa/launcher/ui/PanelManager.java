package fr.chokaaa.launcher.ui;

import com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;
import fr.chokaaa.launcher.Launcher;
import fr.chokaaa.launcher.ui.panel.IPanel;
import fr.chokaaa.launcher.ui.panels.partials.TopBar;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {
    private final Launcher launcher;
    private final Stage stage;
    private GridPane layout;
    private final TopBar topBar = new TopBar();
    private final GridPane contentPane = new GridPane();


    public PanelManager(Launcher launcher, Stage stage) {
        this.launcher = launcher;
        this.stage = stage;
    }

    public void init() {
        this.stage.setTitle("Irkelia");
        this.stage.setMinWidth(854);
        this.stage.setMinHeight(480);
        this.stage.setWidth(1280);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.getIcons().add(new Image("images/icon.png"));

        this.layout = new GridPane();

        BorderlessScene scene = new BorderlessScene(this.stage, StageStyle.UNDECORATED, this.layout);
        scene.setResizable(true);
        scene.setMoveControl(this.topBar.getLayout());
        scene.removeDefaultCSS();

        this.stage.setScene(scene);

        this.stage.show();

        RowConstraints topPaneConstraint = new RowConstraints();
        topPaneConstraint.setValignment(VPos.TOP);
        topPaneConstraint.setMinHeight(25);
        topPaneConstraint.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPaneConstraint, new RowConstraints());
        this.layout.add(this.topBar.getLayout(), 0, 0);
        this.topBar.init(this);

    }

    public void showPanel(IPanel panel) {
        this.contentPane.getChildren().clear();
        this.contentPane.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public Stage getStage() {
        return stage;
    }

    public Launcher getLauncher() {
        return launcher;
    }
}
