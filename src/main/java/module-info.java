module edu.redwoods.assemble.assemble2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.redwoods.assemble.assemble2 to javafx.fxml;
    exports edu.redwoods.assemble.assemble2;
}