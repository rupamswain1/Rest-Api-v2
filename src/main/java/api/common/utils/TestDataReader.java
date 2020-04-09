package api.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author RUPAM
 *This Class will be used to read test data file
 */
public class TestDataReader {

	private Workbook workbook=null;
	private Sheet sheet=null;
	private String testData=null;
	private FileInputStream fis=null;
	public TestDataReader() throws Exception {
		// TODO Auto-generated constructor stub
		testData=new PropertFileReader().getApplicationData("TestDataFilePath");
	}
	public String getTestData() {
		return testData;
	}


	public void setTestData(String testData) {
		this.testData = testData;
	}


	public FileInputStream getFis() {
		return fis;
	}


	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}


	public Workbook getWorkbook() {
		return workbook;
	}


	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}


	public Sheet getSheet() {
		return sheet;
	}


	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
	/**
	 * 
	 * @param dataName this name will be passed from dataprovider method, it is the name of method for which data is required
	 * @return returns a list of map<String,String>
	 * @throws Exception
	 */
	public List<Map<String, String>> getData(String methodName) throws Exception
	{
		TestDataReader reader=new TestDataReader();
		reader.setFis(new FileInputStream(new File(this.testData)));
		reader.setWorkbook(new XSSFWorkbook(reader.getFis()));
		int sheets=reader.getWorkbook().getNumberOfSheets();
		//System.out.println("Sheet Count: "+sheets);
		int dataStartCell=0;
		int dataSheet=0;
		boolean dataFound=false;
		MainLoop:
		for(int i=0;i<sheets;i++)
		{
			reader.setSheet(reader.getWorkbook().getSheetAt(i));
			int firstRow=reader.getSheet().getFirstRowNum();
			//System.out.println("First Roe"+ firstRow);
			int lastRow=reader.getSheet().getLastRowNum();
			//System.out.println("Last Row: "+lastRow);
			for(int j=firstRow;j<=lastRow;j++)
			{
				int cols=0;
				Row row=reader.getSheet().getRow(j);
				try {
					cols=row.getLastCellNum();
					//System.out.println("First Cell: "+row.getFirstCellNum());
					//System.out.println("Last cell Num for Row: "+j+" is: "+cols);
				}
				catch (NullPointerException e) {
					continue;
				}
				
				dataLoop:
				for(int k=0;k<cols;k++)
				{
					String colContent=null;
					try {
						colContent=row.getCell(k).getStringCellValue();
						//System.out.println("Cell Content for cell: "+k+" is: "+colContent);
					}
					catch (NullPointerException e) {
						colContent="";
					}
					catch (IllegalStateException o) {
						// TODO: handle exception
						colContent="";
					}
					
				
					if(colContent.equalsIgnoreCase(methodName))
					{
						//System.out.println("data name matched: "+colContent);
						dataStartCell=j;
						dataFound=true;
						dataSheet=i;
						break MainLoop;
					}
					
				}
							
			}
			
			
		}
		Map<String, String> data=null;
		List<Map<String, String>> dataList=new ArrayList<Map<String,String>>();
		if(dataFound==false)
		{
			throw new Exception("Test Data for test method "+methodName+ " not Found");
		}
		else {
			reader.setSheet(reader.getWorkbook().getSheetAt(dataSheet));
			//System.out.println("data start cell: "+dataStartCell);
			dataLoop:
			for(int i=dataStartCell+2;i<=reader.getSheet().getLastRowNum();i++)
			{
				boolean flag=false;
				int header=dataStartCell+1;
				Row row=reader.getSheet().getRow(i);
				try {
					int num=row.getLastCellNum();
				}
				catch(NullPointerException n)
				{
					break dataLoop;
				}
				
				int colCount=row.getLastCellNum();
				data=new Hashtable<String, String>();
				for(int j=1;j<colCount;j++)
				{
					Cell cell=row.getCell(j);
					
					if(row.getCell(0).getStringCellValue().equalsIgnoreCase("yes"))
					{
						//System.out.println("Found Yes");
						flag=true;
						try{
							String cellType=cell.getCellType().toString();
							//System.out.println("Cell Style: "+cell.getCellType());
							if(cellType.equals("STRING"))
							{
								data.put(reader.getSheet().getRow(header).getCell(j).getStringCellValue(),cell.getStringCellValue());
							}
							else if(cellType.equals("BOOLEAN"))
							{
								data.put(reader.getSheet().getRow(header).getCell(j).getStringCellValue(),cell.getBooleanCellValue()+"");
							}
							else if (cellType.equals("NUMERIC")) {
								data.put(reader.getSheet().getRow(header).getCell(j).getStringCellValue(),cell.getNumericCellValue()+"");
							}
							
							
						}
						catch (NullPointerException e) {
							break dataLoop;
						}
					}
					
					//System.out.println(data);
				}
				
				//System.out.println(data);
				if(flag==true)
				{
					dataList.add(data);
				}
				
			}
		
		}
		//System.out.println(dataList.size());
		return dataList;
	}
	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Map<String, String>> data=new TestDataReader().getData("Method2");
		System.out.println(data.size());
		for(Map<String, String> a:new TestDataReader().getData("Method2"))
		{
			System.out.println(a);
		}
	}*/

}
