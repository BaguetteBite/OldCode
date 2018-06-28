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

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  size( 1200, 600 );

  // DEFAULT MAP
  fileName = FILE_NAMES_ELECTIONS[0];

  // ELECTION RESULTS
  electionResult();
  
}

/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
void electionResult( ) {
  try {
    
    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\" + fileName ) );
    int lineCount = 1;
    while ( data.hasNextLine() )
    {      
      
      if (lineCount == 1)
      {
        data.nextLine();  
      }  
      
      else
      {
        for ( int i = 0; i < data.length() - 1; i++}
        {
          
        }
      }
      
      
    }
    
    data.close();
    
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() 
{
  // MAP
  try 
  {
    
  
    // USA MAP DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\USA.txt" ) );
    while (data.hasNextLine())
    {
      
      for ( int i = 0; i <= 53; i++}
        {
          
        }
    }
    
    data.close();
    
    //Read file  
    //Make a while loop to read the file line by line
    //Make a for loop for each state (Set i to 52)
    
    //Skip first 4 lines with a counter
    //Skip a line
    //Get the third line containing the number of coordinates
    //Make for loop: int i = 1; i <= # of coordinates
    //Use beginShape()
    //Use a string tokenizer to separate the x and y values
    //Int x = max lat - x
    //Int y = max long - y
    //Use vertex(y,x) to draw the point
    //Exit for loop and endShape()
    //Skip a line
    //Exit for loop for each state and start again
    
  }
  catch (Exception e ) 
  {
    e.printStackTrace();
  }
  
}

/*
 * Draw State
 */
void drawState( ) 
{

}

/*
 */
void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    print( fileName );
    electionResult();
  }
}

//