package kassoc;

import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kassoc.model.Account;
import kassoc.view.Dashboard;
import kassoc.view.model.AccountEdit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * The type Kassoc.
 */
public final class Kassoc {
    private static final SessionFactory sessionFactory;
    /**
     * The constant account.
     */
    public static Account account;
    /**
     * The constant stage.
     */
    public static Stage stage;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    /**
     * Gets current session.
     * @return the current session
     */
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * The type View.
     */
    public static class View {
        /**
         * The constant accountEdit.
         */
        public static AccountEdit accountEdit;
        /**
         * The constant adminTab.
         */
        public static kassoc.view.View<Tab> adminTab;
        /**
         * The constant dashboard.
         */
        public static Dashboard dashboard;
        /**
         * The constant eventTab.
         */
        public static kassoc.view.View<Tab> eventTab;
        /**
         * The constant index.
         */
        public static kassoc.view.View<AnchorPane> index;
        /**
         * The constant login.
         */
        public static kassoc.view.View<AnchorPane> login;
        /**
         * The constant registrationTab.
         */
        public static kassoc.view.View<Tab> registrationTab;
        /**
         * The constant settingsTab.
         */
        public static kassoc.view.View<Tab> settingsTab;
        /**
         * The constant signup.
         */
        public static kassoc.view.View<AnchorPane> signup;

        /**
         * Init.
         * @throws IOException the io exception
         */
        public static void init() throws IOException {
            login = new kassoc.view.View<>("/login.fxml");
            signup = new kassoc.view.View<>("/signup.fxml");
            adminTab = new kassoc.view.View<>("/admin-tab.fxml");
            eventTab = new kassoc.view.View<>("/event-tab.fxml");
            registrationTab = new kassoc.view.View<>("/registration-tab.fxml");
            accountEdit = new AccountEdit();
            settingsTab = new kassoc.view.View<>("/settings-tab.fxml");
            dashboard = new Dashboard();
            index = new kassoc.view.View<>("/index.fxml");
        }
    }
}