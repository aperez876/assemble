module edu.redwoods.assemble.assemble2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens edu.redwoods.assemble.assemble2 to org.hibernate.orm.core, javafx.fxml;
    exports edu.redwoods.assemble.assemble2;
}