package ru.rks.FileDownloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Поток качает файл из указанной ссылки по указанному пути.
 *
 * @author Рязанов К.С.
 */

public class FileLoader extends Thread {
    private String strUrl;
    private String file;

    @Override
    public void run() {
        final long before = System.currentTimeMillis();
        try {
            URL url = new URL(strUrl);
            try (ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
                 FileOutputStream stream = new FileOutputStream(file)) {
                stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        final long after = System.currentTimeMillis();
        System.out.println("time delta: "+ (after-before)+" ms");
    }

    FileLoader(String strUrl, String file) {
        this.strUrl = strUrl;
        this.file = file;
    }
}
