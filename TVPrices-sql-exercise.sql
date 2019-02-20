/* Most statements were created with Ansi compliant sql 
   statements, using PostgreSQL with DBVisualizer */


/* This statement creates the database */

       CREATE DATABASE tvTracker;


/* This statement creates the table
   Decimal was decided best to not use due to errors with money datatype 
   Timestamp was used because DateTime not supported by PostgreSQL */
   
        CREATE TABLE TVPrices(
                TVModel varchar(255) not null,
                DateUpdated timestamp not null,
                Price decimal (6,2) not null
                );


/* This statement was used in leiu of import utility 
   Can be replicated on another machine by changing absolute path to the file */
        COPY TVPrices(TVModel,DateUpdated,price) 
        FROM '/Users/dball/eclipse-workspace/DynamitExerciseWork/Table.csv' DELIMITER ',' CSV HEADER;


/* Read and list the table, optionally ordered by TV Model and date to increase readability */
        SELECT * FROM TVPrices ORDER BY tvmodel, dateupdated DESC;


/* Read and list the table sorted by date updated */
        SELECT * FROM TVPrices WHERE dateupdated < now() ORDER BY dateupdated DESC;


/* Return a unique list of TV Models and the most recent price associated with each model */
        SELECT tvmodel, MAX(dateupdated) as Most_Recent_Update, MAX(price) as Most_Recent_Price FROM TVPrices GROUP BY tvmodel;


/* Bonus: First statement shows list of available models
   Second statement is parameterized to show a single query result based on specific TV Model chosen */
        SELECT tvmodel FROM TVPrices GROUP BY tvmodel;
        
        SELECT tvmodel, MAX(dateupdated) as Most_Recent_Update, MAX(price) as Most_Recent_Price FROM TVPrices WHERE tvmodel = ? GROUP BY tvmodel;

