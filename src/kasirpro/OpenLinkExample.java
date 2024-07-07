
package kasirpro;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenLinkExample {
    public static void main(String[] args) {
        try {
            // URL yang akan dibuka
            String url = "https://www.instagram.com/warungambyar2021?igsh=OGs5dmpkZmxqd2h4";
            
            // Memeriksa apakah operasi Desktop didukung
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                // Membuka URL di browser default
                desktop.browse(new URI(url));
            } else {
                System.out.println("Desktop is not supported");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static void openLink(String httpswwwinstagramcomwarungambyar2021igshO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

