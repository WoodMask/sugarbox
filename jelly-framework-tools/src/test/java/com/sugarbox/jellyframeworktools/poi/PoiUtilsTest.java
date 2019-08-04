package com.sugarbox.jellyframeworktools.poi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sugarbox.jellyframeworktools.poi.constants.PoiTestContstants;
import com.sugarbox.jellyframeworktools.poi.dto.SampleBean;
import com.sugarbox.jellyframeworktools.poi.dto.SampleTree;
import com.sugarbox.jellyframeworktools.poi.utils.PoiTestUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class PoiUtilsTest {


    private static final String FILE_NAME = "templates/MyExcel.xlsx";


    @Test
    public void export() throws Exception {
        SampleBean b1 = new SampleBean("hello", "is", "me");
        SampleBean b2 = new SampleBean("I", "am", "mask");
        List<SampleBean> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        SXSSFWorkbook wb = PoiUtils.export("key", list
               , Arrays.asList(new String[]{"A", "B", "C"}));
        Sheet sheet = wb.getSheetAt(0);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
        export_temple(wb);
    }

    @Test
    public void writeToResponse() throws Exception {
    }

    @Test
    public void getColumnTopStyle() throws Exception {
    }


    public void export_temple(SXSSFWorkbook workbook) {
       /* XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
*/
        try {

            String basePath = "/home/mask/IdeaProjects/sugarbox/jelly-framework-tools/src/main/resources/";
            File file = new File(basePath+FILE_NAME);
            FileOutputStream outputStream = new FileOutputStream( file, false);
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }


    @Test
    public void loadData(){
        List<SampleTree> list = PoiTestUtils.transformJsonArray(JSON.parseArray(PoiTestContstants.treeStr));
    }

    /**
     * Name: 计算树的深度和节点占用格数<p></p>
     * Desc: <p></p>
     **/
    private List<JSONObject> calculateTree(List<SampleTree> trees){
        if (trees == null) {
            return null;
        }
        List<JSONObject> list = new LinkedList<>();
        trees.forEach(tree -> {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(tree);

        });

        return null;
    }

    private int calculateLeaves(JSONObject node) {
        if (node == null) {
            return 0;
        }
        int leaves = 1;
        JSONArray children = node.getJSONArray("children");
        if (children == null) {
            return leaves;
        }
        leaves = 0;
        for (Object c : children) {
            leaves += calculateLeaves(JSON.parseObject(c.toString()));
        }

        return leaves;
    }

}