/*
 * 'Merica
 * 2017-18.S2
 */
import java.util.Scanner;
import java.util.StringTokenizer;

final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt"
};

int value;
String fileName;
String[][] electionResults;
StringTokenizer st;

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  size( 1200, 600 );

  // DEFAULT MAP
  fileName = FILE_NAMES_ELECTIONS[0];

  // ELECTION RESULTS
  electionResult();
  drawMap();
}

/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
void electionResult( ) {
  try {

    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\" + fileName ) );
    int r = -1;
    String str;
    electionResults= new String[52][4];

    while ( data.hasNextLine() )
    {      
      if (r == -1)
      {
        data.nextLine();
      } else
      {   
        str = data.nextLine(); 
        String [] line = str.split(",");

        for (int c = 0; c < line.length; c++)
        {
          electionResults[r][c] = line[c]; 
          //println(electionResults[r][c]);
        }
      }   
      r ++;
    }

    //String a = electionResults[49][0];
    //int b = Integer.parseInt( electionResults[49][1] );
    //println(b);

    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() {
  // MAP
  try {

    float longitude, latitude, x, y;
    String state;
    int numOfXY;

    //Use min long and max lat
    // USA MAP DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\USA.txt" ) );

    float minLong = data.nextFloat();
    float minLat = Float.parseFloat ( data.nextLine() );

    float maxLong = data.nextFloat();
    float maxLat = Float.parseFloat ( data.nextLine() );

    int blue;
    int red;
    int other;

    int regions = Integer.parseInt ( data.nextLine() );

    // DRAW FOR EACH REGION
    float sum;
    for ( int r = 0; r < regions; r++ ) {

      // SKIP LINE
      data.nextLine();

      // STATE
      state = data.nextLine();
      //println( state );
      data.nextLine();

      // GET CORRECT COLOR


      // # of points
      numOfXY = Integer.parseInt ( data.nextLine() );
      
      // LINEAR SEARCH
        for (int i = 0; i < 50; i++)
        {
          if( state.equals(  electionResults[i][0] ) ) {
            blue = Integer.parseInt( electionResults[i][1] );
            red = Integer.parseInt( electionResults[i][2] );
            other = Integer.parseInt( electionResults[i][3] );
            
            sum = blue + red + other;
            
            
            fill( (red/sum * 255.0), (other/sum * 255.0), (blue/sum * 255.0) );
            i = 50;
          }
        }

      //Loops through a single state
      beginShape();
      for ( int xy = 0; xy < numOfXY; xy++ ) {

        x = data.nextFloat();
        y = Float.parseFloat ( data.nextLine() );
        // MOVE X RIGHT
        // MOVE Y DOWN
        // FLIP Y VALUES

        //println( x + "," + y );

        //println(electionResults[xy][1]);
        //blue = Integer.parseInt( electionResults[xy][1] );
        //red = Integer.parseInt( electionResults[xy][2] );
        vertex( (x + 135) * 15, (maxLat - y + 10) * 15 );    

        
      
        //Make a variable for blue and red

        //Put variables in array
        //Check whether blue or red is more
        //Make if statement depending on color, ignoring green
        //Delete the counter code
      }
      endShape();

    }


    data.nextLine();     
    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * Draw State
 */
void drawState( ) 
{
  
}

void draw() {
  
}

/*
 */
void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    print( fileName );
    electionResult();
    drawMap();
  }
}