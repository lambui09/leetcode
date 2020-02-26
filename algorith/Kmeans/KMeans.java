package Kmeans;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {
    public static void main(String[] args) throws IOException {
        int[][] x = new int[][]{{3, 1}, {0, 3}, {1, 4}, {4, 1}};
        final KMeans kMeans = new KMeans(x, 2);
        for (int i = 0; i < x.length; i++) {
            System.out.println(kMeans.id[i]);
        }

        nenAnh();
    }

    private static void nenAnh() throws IOException {
        final File file = new File("/Users/mac/Downloads/SAM_0810.JPG");
        final BufferedImage image = ImageIO.read(file);

        final List<int[]> pixels = new ArrayList<>();
        for (int y = 0; y < image.getHeight(); y += 5) {
            for (int x = 0; x < image.getWidth(); x += 5) {
                final int rgb = image.getRGB(x, y);
                final int b = rgb & 0xff;
                final int g = (rgb >> 8) & 0xff;
                final int r = (rgb >> 16) & 0xff;
                pixels.add(new int[]{r, g, b});
            }
        }


        final int[][] data = pixels.toArray(new int[0][]);
        final KMeans kMeans = new KMeans(data, 2);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                final int rgb = image.getRGB(x, y);
                final int b = rgb & 0xff;
                final int g = (rgb >> 8) & 0xff;
                final int r = (rgb >> 16) & 0xff;

                final int id = kMeans.divide(new int[]{r, g, b});
                final int newR = kMeans.c[id][0];
                final int newG = kMeans.c[id][1];
                final int newB = kMeans.c[id][2];
                final int newRgb = newB + (newG << 8) + (newR << 16);
                image.setRGB(x, y, newRgb);
            }
        }

        new JFrame() {
            {
                setSize(image.getWidth(), image.getHeight());
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }

            @Override
            public void paint(Graphics g) {
                g.drawImage(image, 0, 0, null);
            }
        }.setVisible(true);
    }

    private final int[][] data;
    private final int k;

    final int[] id;
    public final int[][] c;

    public KMeans(int[][] data, int k) {
        this.data = data;
        this.k = k;

        this.id = new int[data.length];
        this.c = new int[k][data[0].length];

        process();
    }

    private void process() {
        final Random random = new Random();
        // B1
        for (int i = 0; i < id.length; i++) {
            id[i] = random.nextInt(k);
        }

        //B2-B4
        while (true) {
            // B2
            final int[] count = new int[k];

            for (int i = 0; i < data.length; i++) {
                final int id = this.id[i];
                count[id]++;
                for (int j = 0; j < data[i].length; j++) {
                    c[id][j] += data[i][j];
                }
            }

            for (int i = 0; i < k; i++) {
                final int countI = count[i];

                if (countI != 0) {
                    for (int j = 0; j < c[i].length; j++) {
                        c[i][j] /= countI;
                    }
                } else {
                    final int x = random.nextInt(data.length);
                    for (int j = 0; j < c[i].length; j++) {
                        c[i][j] = data[x][j];
                    }
                }
            }

            // B3
            boolean change = false;
            for (int i = 0; i < data.length; i++) {
                final int newId = divide(data[i]);
                if (newId != id[i]) {
                    change = true;
                }
                id[i] = newId;
            }

            // b4
            if (!change) {
                break;
            }
        }
    }

    public int divide(int[] x) {
        int id = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            int d = distance(x, c[i]);
            if (d < min) {
                min = d;
                id = i;
            }
        }

        return id;
    }

    private int distance(int[] x, int[] y) {
        int d = 0;
        for (int i = 0; i < x.length; i++) {
            d += (x[i] - y[i]) * (x[i] - y[i]);
        }
        return d;
    }
}
