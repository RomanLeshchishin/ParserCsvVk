import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javax.imageio.ImageIO;
import java.io.File;

public class CreateCharts extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        var chart = new Charts();
        var names = chart.getNamesGenders();
        chart.Open();
        var genders = chart.SelectGender();
        chart.Close();
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data(names.get(0), genders.get(0)),
                new PieChart.Data(names.get(1), genders.get(1))
                );
        PieChart pChart = new PieChart(pieData);
        Group root = new Group(pChart);
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Gender");
        primaryStage.setScene(scene);
        primaryStage.show();
        WritableImage snapShot = scene.snapshot(null);
        ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("pieChartGenders.png"));
    }
}
