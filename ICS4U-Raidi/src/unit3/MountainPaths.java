/*
 * Mountain Paths - Greedy Algorithm
 * Mr. Muir
 * 2018.03.26 - v1.0
 */
package unit3;

import java.util.*;
import java.io.*;
import java.awt.*;
import unit2.DrawingPanel;

public class MountainPaths {

    /**
     * Mount Paths
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println("TASK 1: READ DATA");
        int[][] data = read("Colorado.844x480.dat");

        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        DrawingPanel panel = new DrawingPanel(data[0].length, data.length);
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println("TASK 2: HIGHEST / LOWEST ELEVATION");
        int min = findMinValue(data);
        System.out.println("\tMin: " + min);

        int max = findMaxValue(data);
        System.out.println("\tMax: " + max);

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println("TASK 3: DRAW MAP");
        drawMap(g, data);

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println("TASK 4A: INDEX OF MIN IN COL 0");
        int minRow = indexOfMinInCol(data, 0);
        System.out.println("\tRow with lowest Col 0 Value: " + minRow);

        // ***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println("TASK 4B: PATH from LOWEST STARTING ELEVATION");
        g.setColor(Color.RED);

        //Locates the lowest distance the path can take
        int totalChange = 0;
        for (int r = 0; r < 480; r++) {
            totalChange = drawLowestElevPath(g, data, r, 0);
        }
        g.setColor(Color.RED);

        System.out.println("\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange);

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        int bestRow = indexOfLowestElevPath(g, data);
        //System.out.println("Best row: " + bestRow);

        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println("TASK 6: DRAW BEST PATH");
        g.setColor(Color.GREEN);
        drawLowestElevPath(g, data, bestRow, 0);
        System.out.println("\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange);

    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read(String fileName) throws FileNotFoundException {

        //Creates an array, scanner, and inputs a file
        int[][] data;
        File map = new File(".\\data\\mountain.paths\\" + fileName);
        Scanner in = new Scanner(map);

        //Initializes row and column
        int r = 0;
        int c = 0;

        //Reads the first line to determine number of columns
        String line = in.nextLine();
        r++;
        StringTokenizer st = new StringTokenizer(line);
        c = st.countTokens();

        //Reads every line in the file to determine number of rows
        while (in.hasNextLine()) {
            r++;
            in.nextLine();
        }

        //Sets array size
        data = new int[r][c];

        //Read file into array, one int at a time
        in = new Scanner(map);
        for (r = 0; r < data.length; r++) {
            st = new StringTokenizer(in.nextLine());
            for (c = 0; c < data[r].length; c++) {
                data[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //Returns the full array
        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue(int[][] data) {

        //Sets the minimum value to max, so that no minimum values are missed
        int min = Integer.MAX_VALUE;

        //Finds the smallest value in the array
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] < min) {
                    min = data[r][c];
                }
            }
        }

        //Returns the smallest value
        return min;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue(int[][] data) {

        //Sets the maximum value to min, so that no maximum values are missed
        int max = Integer.MIN_VALUE;

        //Finds the largest value in the array
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] > max) {
                    max = data[r][c];
                }
            }
        }

        //Returns the largest value
        return max;

    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param data
     */
    public static void drawMap(Graphics g, int[][] data) {
        //Calls methods for the largest and smallest values in the array
        int min = findMinValue(data);
        int max = findMaxValue(data);

        //Finds the difference of the max and min values to create a scale
        //Scale used to display values in terms of greyscale
        int difference = max - min;
        double scale = difference / 255;
        int color;

        //Colours each pixel of board according to greyscale value previously calculated
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                color = (int) ((data[r][c] - min) / scale);
                g.setColor(new Color(color, color, color));
                g.drawRect(c, r, 1, 1);
            }
        }
    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param data
     * @param col
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol(int[][] data, int col) {

        //Initializes a minimum value and a row. Column = 0.
        int min = Integer.MAX_VALUE;
        int row = 0;

        //Identifies the row where the smallest value in column 0 exists
        for (int r = 0; r < data.length; r++) {
            if (data[r][col] < min) {
                min = data[r][col];
                row = r;
            }
        }

        //Returns the row.
        return row;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param data
     * @param row - the starting row for traversing to find the min path
     * @param col
     * @return total elevation of the route
     */
    public static int drawLowestElevPath(Graphics g, int[][] data, int row, int col) {

        //Draws small rectangles 1x1 pixel in size
        //These form a line
        g.fillRect(col, row, 1, 1);

        //Base case for when the current location is at the end of the map
        if (col == data[row].length - 1) {
            return 0;
        }

        //Sets the currect location where the rectangle starts
        int currentLoc = data[row][col];

        //Initializes variables for directions and their elevations
        //Random is used for instances where paths have the same elevation change (explained later)
        int smallestChange;
        int up, straight, down;

        //If the current location is at the top of the map, you cannot go up.
        if (row == 0) {
            up = Integer.MAX_VALUE;
        } else {
            //Collects elevation of location 1 up and 1 right of current location
            up = Math.abs(data[row - 1][col + 1] - currentLoc);
        }

        //If the current location is at the bottom of the map, you cannot go down.
        if (row == data.length - 1) {
            down = Integer.MAX_VALUE;
        } else {
            //Collects elevation of location 1 down and 1 right of current location
            down = Math.abs(data[row + 1][col + 1] - currentLoc);
        }

        //Collects elevation of location 1 right of current location
        straight = Math.abs(data[row][col + 1] - currentLoc);

        // FORWARD
        if (straight <= up && straight <= down) {
            return straight + drawLowestElevPath(g, data, row, col + 1);
        }
        if (up < down) {
            return up + drawLowestElevPath(g, data, row - 1, col + 1);
        }
        if (down < up) {
            return down + drawLowestElevPath(g, data, row + 1, col + 1);
        }

        // UP OR DOWN?
        int r = (int) (Math.random() * 2);
        if (r == 1) {
            return up + drawLowestElevPath(g, data, row - 1, col + 1);
        }

        return down + drawLowestElevPath(g, data, row + 1, col + 1);
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param data
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath(Graphics g, int[][] data) {

        //Sets variables for the lowest row distance and corresponding change
        int lowestRow = -1;
        int lowestChange = Integer.MAX_VALUE;
        int change;

        //Locates the lowest path and draws it
        for (int r = 0; r < data.length; r++) {
            change = drawLowestElevPath(g, data, r, 0);
            if (change < lowestChange) {
                lowestChange = change;
                lowestRow = r;
            }
        }
        return lowestRow;
    }

}
