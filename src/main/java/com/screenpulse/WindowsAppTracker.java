package com.screenpulse;

import com.sun.jna.Native;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.Timer;
import java.util.TimerTask;

import static com.screenpulse.App.scene;

public class WindowsAppTracker {

    private static final long INTERVAL_MS = 1000; // Check every second
    private static Timer timer = new Timer();

    public static void main(String[] args) {
        startTracking();
    }

    public static void startTracking() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task is running...");
                String activeAppName = getActiveApplicationName();
                System.out.println("Active Application: " + activeAppName);
                updateTrackingPage(activeAppName);
            }
        }, 0, INTERVAL_MS);
    }

    private static String getActiveApplicationName() {
        char[] buffer = new char[1024];
        User32.INSTANCE.GetWindowText(User32.INSTANCE.GetForegroundWindow(), buffer, 1024);
        return Native.toString(buffer);
    }

    private static void updateTrackingPage(String appName) {
        Parent root = scene.getRoot();

        if (root != null) {
            if (root instanceof VBox) {
                if (scene.getRoot() != null) {
                    TrackingPageController controller = App.getController((Parent) scene.getRoot(), TrackingPageController.class);
                    controller.updateActiveAppLabel(appName);
                }
            }
        }
    }

    interface User32 extends com.sun.jna.platform.win32.User32 {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

        HWND GetForegroundWindow();

        int GetWindowText(HWND hWnd, char[] lpString, int nMaxCount);
    }
}
