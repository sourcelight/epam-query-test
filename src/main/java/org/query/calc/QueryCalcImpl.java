package org.query.calc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.query.model.entity.T1;
import org.query.model.entity.T2;
import org.query.model.entity.T3;
import org.query.repository.T1Repository;
import org.query.repository.T1Repository.Projection;
import org.query.repository.T2Repository;
import org.query.repository.T3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

@Component
public class QueryCalcImpl implements QueryCalc {

	
	public QueryCalcImpl() {
		super();		
	}
	
	@Autowired
	@Qualifier("t1Repository")
	private T1Repository t1Repository;
	
	@Autowired
	@Qualifier("t2Repository")
	private T2Repository t2Repository;
	
	@Autowired
	@Qualifier("t3Repository")
	private T3Repository t3Repository;


	@Override
    public void select(Path t1, Path t2, Path t3, Path output) throws IOException {
		
		List<String[]> parsedRows = null;
   	
		parsedRows = loadTables(t1);		
		parsedRows.stream().map(row -> row[0].split(" ")).
		map(arr->{double[] myDoubleArray = {Double.parseDouble(arr[0]),Double.parseDouble(arr[1]) };return myDoubleArray; }).forEach(d->t1Repository.save(new T1(null, d[0], d[1])));
		
		parsedRows = loadTables(t2);		
		parsedRows.stream().map(row -> row[0].split(" ")).
		map(arr->{double[] myDoubleArray = {Double.parseDouble(arr[0]),Double.parseDouble(arr[1]) };return myDoubleArray; }).forEach(d->t2Repository.save(new T2(null, d[0], d[1])));

		
		parsedRows = loadTables(t3);		
		parsedRows.stream().map(row -> row[0].split(" ")).
		map(arr->{double[] myDoubleArray = {Double.parseDouble(arr[0]),Double.parseDouble(arr[1]) };return myDoubleArray; }).forEach(d->t3Repository.save(new T3(null, d[0], d[1])));

		t1Repository.findAll();
		List<Projection> list = t1Repository.extractResults();	
						
		List<List<String>> result1 =list.stream().map(r-> List.of(r.getA()+" "+r.getS())).collect(Collectors.toList());
		result1.add(0, Arrays.asList(""+list.size()));
		
		CsvWriter csvWriter = new CsvWriter(output.toFile(), new CsvWriterSettings());
		csvWriter.writeRowsAndClose(result1);
		
		System.out.println("trest");		
			
			
//			t1Repository.save(new T1(null, d[0], d[1]));

		//verify spring boot reads from application.properties
		//try to get a better generic method to extracts data
    	//read the files
    	//create 3 enities
    	//create a layer with data jpa
    	//insert the data into tables
    	//create and execute the query
    	//extract the result of the query into the ouput file
    	
        // - t1 is a file contains table "t1" with two columns "a" and "x". First line is a number of rows, then each
        //  line contains exactly one row, that contains two numbers parsable by Double.parse(): value for column a and
        //  x respectively.See test resources for examples.
        // - t2 is a file contains table "t2" with columns "b" and "y". Same format.
        // - t3 is a file contains table "t3" with columns "c" and "z". Same format.
        // - output is table stored in the same format: first line is a number of rows, then each line is one row that
        //  contains two numbers: value for column a and s.
        //
        // Number of rows of all three tables lays in range [0, 1_000_000].
        // It's guaranteed that full content of all three tables fits into RAM.
        // It's guaranteed that full outer join of at least one pair (t1xt2 or t2xt3 or t1xt3) of tables can fit into RAM.
        //
        // TODO: Implement following query, put a reasonable effort into making it efficient from perspective of
        //  computation time, memory usage and resource utilization (in that exact order). You are free to use any lib
        //  from a maven central.
        //
        // SELECT a, SUM(x * y * z) AS s FROM 
        // t1 LEFT JOIN (SELECT * FROM t2 JOIN t3) AS t
        // ON a < b + c
        // GROUP BY a
        // STABLE ORDER BY s DESC
        // LIMIT 10;
        // 
        // Note: STABLE is not a standard SQL command. It means that you should preserve the original order. 
        // In this context it means, that in case of tie on s-value you should prefer value of a, with a lower row number.
        // In case multiple occurrences, you may assume that group has a row number of the first occurrence.
    }


	/**
	 * @param <T>
	 * @param t1
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private  List<String[]>  loadTables(Path path) throws UnsupportedEncodingException, FileNotFoundException {
		Reader inputReader = new InputStreamReader(new FileInputStream(path.toFile()), "UTF-8");		
		CsvParser parser = new CsvParser(new CsvParserSettings());			
		List<String[]> parsedRows = parser.parseAll(inputReader);							
		parsedRows.remove(0);
		return parsedRows;		
	}
}
