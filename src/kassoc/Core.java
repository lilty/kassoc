package kassoc;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import kassoc.model.AccountEntity;
import kassoc.view.model.AccountEdit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * The type Core.
 */
public final class Core {
    private static final SessionFactory sessionFactory;
    /**
     * The constant account.
     */
    public static AccountEntity account;

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
         * The constant admin.
         */
        public static kassoc.view.View<Tab> admin;
        /**
         * The constant dashboard.
         */
        public static kassoc.view.View<TabPane> dashboard;
        /**
         * The Event.
         */
        public static kassoc.view.View<AnchorPane> event;
        /**
         * The Event.
         */
        public static kassoc.view.View<AnchorPane> eventEdit;
        /**
         * The Event.
         */
        public static kassoc.view.View<AnchorPane> eventItem;
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
         * The constant registration.
         */
        public static kassoc.view.View<Tab> registration;
        /**
         * The constant settings.
         */
        public static kassoc.view.View<Tab> settings;
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
            admin = new kassoc.view.View<>("/admin.fxml");
            eventTab = new kassoc.view.View<>("/event-tab.fxml");
            registration = new kassoc.view.View<>("/registration.fxml");
            accountEdit = new AccountEdit();
            settings = new kassoc.view.View<>("/settings.fxml");
            dashboard = new kassoc.view.View<>("/dashboard.fxml");
            index = new kassoc.view.View<>("/index.fxml");
            event = new kassoc.view.View<>("/event.fxml");
            eventEdit = new kassoc.view.View<>("/event-edit.fxml");
            eventItem = new kassoc.view.View<>("/event-item.fxml");
        }
    }
}